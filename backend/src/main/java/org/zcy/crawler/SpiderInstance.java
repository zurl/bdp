package org.zcy.crawler;

import org.zcy.entity.Task;
import us.codecraft.webmagic.Spider;

/**
 * Created by zcy on 2017/2/9.
 */
public class SpiderInstance {
    Spider spider;
    Task task;

    public SpiderInstance(Spider spider, Task task) {
        this.spider = spider;
        this.task = task;
    }
}
