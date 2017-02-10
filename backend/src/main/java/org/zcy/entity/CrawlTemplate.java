package org.zcy.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zcy on 2017/2/9.
 */

@Entity
public class CrawlTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date createdDate = new Date();

    @Basic(optional=true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }
    private String entryURL;
    private String URLPattern;
    private String TitleXPath;
    private String ContentXPath;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntryURL() {
        return entryURL;
    }

    public void setEntryURL(String entryURL) {
        this.entryURL = entryURL;
    }

    public String getURLPattern() {
        return URLPattern;
    }

    public void setURLPattern(String URLPattern) {
        this.URLPattern = URLPattern;
    }

    public String getTitleXPath() {
        return TitleXPath;
    }

    public void setTitleXPath(String titleXPath) {
        TitleXPath = titleXPath;
    }

    public String getContentXPath() {
        return ContentXPath;
    }

    public void setContentXPath(String contentXPath) {
        ContentXPath = contentXPath;
    }

    protected CrawlTemplate() {}

    public CrawlTemplate(String name, Date createdDate, String entryURL, String URLPattern, String titleXPath, String contentXPath) {
        this.name = name;
        this.createdDate = createdDate;
        this.entryURL = entryURL;
        this.URLPattern = URLPattern;
        TitleXPath = titleXPath;
        ContentXPath = contentXPath;
    }
}
