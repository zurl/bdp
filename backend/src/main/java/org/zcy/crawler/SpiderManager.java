package org.zcy.crawler;

import com.sun.javafx.binding.Logging;
import org.zcy.entity.CrawlTemplate;
import org.zcy.entity.Task;
import org.zcy.repository.CrawlTemplateResource;
import org.zcy.repository.DataStorageResource;
import org.zcy.repository.TaskResource;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zcy on 2017/2/9.
 */

public class SpiderManager {

    static final int MAX_THREAD = 10;
    static final int MAX_TASK = 10;


    private TaskResource taskResource;
    private CrawlTemplateResource crawlTemplateResource;
    private DataStorageResource dataStorageResource;
    ExecutorService executor;

    public SpiderManager(TaskResource taskResource, CrawlTemplateResource crawlTemplateResource, DataStorageResource dataStorageResource) {
        this.taskResource = taskResource;
        this.crawlTemplateResource = crawlTemplateResource;
        this.dataStorageResource = dataStorageResource;
        executor = Executors.newFixedThreadPool(MAX_TASK);
    }

    private int threadIdle = MAX_THREAD;

    synchronized int threadIdleOpe(boolean ope, int val){
        if( ope ){ //read
            return threadIdle;
        }
        else{ // read and write
            threadIdle += val;
            return threadIdle;
        }
    }

    final static Long S_STOP = 0L;
    final static Long S_RUN = 1L;
    final static Long S_WAIT = 2L;
    final static Long S_WAITSTOP = 3L;
    final static Long S_PAUSE = 4L;
    final static Long S_FIN = 5L;

    List<SpiderInstance> spiderInstances = new ArrayList<>();

    void findTaskStop(){
        List<Task> tasks = taskResource.findByStatus(S_WAITSTOP);
        if( !tasks.isEmpty() ) {
            for(SpiderInstance spiderInstance : spiderInstances){
                if(spiderInstance.task.getId().equals(tasks.get(0).getId())){
                    spiderInstance.spider.stop();
                    spiderInstance.task = taskResource.findOne(spiderInstance.task.getId());
                    spiderInstance.task.setStatus(S_STOP);
                    taskResource.save(spiderInstance.task);
                    spiderInstances.remove(spiderInstance);
                    return;
                }
            }
        }
    }

    void findTaskWait(){
        List<Task> tasks = taskResource.findByStatus(S_WAIT);
        if( !tasks.isEmpty() ){
            tasks.get(0).setStatus(S_RUN);
            tasks.get(0).setTotal(0L);
            taskResource.save(tasks.get(0));
            CrawlTemplate crawlTemplate
                    = crawlTemplateResource.findOne(tasks.get(0).getTemplateId());
            if( crawlTemplate != null){
                Task task = tasks.get(0);
                int threads = Math.min(task.getThread().intValue(), threadIdle);
                threadIdleOpe(false, -threads);
                SpiderInstance spiderInstance = new SpiderInstance(
                        Spider
                                .create( new GeneralPageProcessor(
                                        crawlTemplate.getTitleXPath(),
                                        crawlTemplate.getContentXPath(),
                                        crawlTemplate.getURLPattern()
                                ))
                                .addPipeline(new JPAPipeline(
                                        taskResource,
                                        dataStorageResource,
                                        task
                                ))
                                .addUrl(crawlTemplate.getEntryURL())
                                .thread(threads),
                        task);
                spiderInstances.add(spiderInstance);
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        spiderInstance.spider.run();
                        threadIdleOpe(false, threads);
                        spiderInstances.remove(spiderInstance);
                    }
                });
            }
        }
    }


    public void run(){
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(" debug lx");
                if(threadIdleOpe(true, 0) > 0){
                    System.out.println(" debug <");
                    findTaskWait();
                }
                findTaskStop();
                System.out.println(" debug > end");
            }
        }, 1, 5, TimeUnit.SECONDS);
    }
}
