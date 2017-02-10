package org.zcy.crawler;

import org.zcy.entity.DataStorage;
import org.zcy.repository.DataStorageResource;
import org.zcy.repository.TaskResource;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by zcy on 2017/2/9.
 */
public class JPAPipeline implements Pipeline {

    private TaskResource taskResource;
    private DataStorageResource dataStorageResource;

    private org.zcy.entity.Task MyTask;

    private synchronized void increaseTaskCnt(){
        MyTask = taskResource.findOne(MyTask.getId());
        MyTask.setTotal(MyTask.getTotal() + 1);
        taskResource.save(MyTask);
    }

    public JPAPipeline(TaskResource taskResource, DataStorageResource dataStorageResource, org.zcy.entity.Task myTask) {
        this.taskResource = taskResource;
        this.dataStorageResource = dataStorageResource;
        MyTask = myTask;
    }

    public void process(ResultItems resultItems, Task task){
        if(resultItems.get("content") != null && resultItems.get("title") != null){
            increaseTaskCnt();
            dataStorageResource.save(
                    new DataStorage(
                            MyTask.getId(),
                            resultItems.get("url"),
                            resultItems.get("content"),
                            resultItems.get("title")
                    )
            );
        }
    }
}
