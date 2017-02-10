package org.zcy.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * Created by zcy on 2017/2/9.
 */

@Entity
public class Task {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdDate = new Date();

    @Basic(optional=true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }

    private Long templateId;
    private String name;
    private Long thread;

    private Long status;
    private Long total;
    private Long priority;

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getName() {
        return name;
    }

    protected Task() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getThread() {
        return thread;
    }

    public void setThread(Long thread) {
        this.thread = thread;
    }

    public Task(Long templateId, String name, Long thread, Long status, Long total, Long priority) {
        this.templateId = templateId;
        this.name = name;
        this.thread = thread;
        this.status = status;
        this.total = total;
        this.priority = priority;
    }
}
