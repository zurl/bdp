package org.zcy.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zcy on 2017/2/9.
 */

@Entity
public class DataStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long taskId;
    private String url;

    @Column(length = 65535)
    private String content;

    @Column(length = 65535)
    private String title;

    private Date createdDate = new Date();

    @Basic(optional=true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }
    protected DataStorage() {}

    public DataStorage(Long taskId, String url, String content, String title) {
        this.taskId = taskId;
        this.url = url;
        this.content = content;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
