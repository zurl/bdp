package org.zcy.crawler;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by zcy on 2017/2/9.
 */
public class GeneralPageProcessor implements PageProcessor{

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    private String titleXPath;
    private String contentXPath;
    private String URLRegex;

    public GeneralPageProcessor(String titleXPath, String contentXPath, String URLRegex) {
        this.titleXPath = titleXPath;
        this.contentXPath = contentXPath;
        this.URLRegex = URLRegex;
    }

    @Override
    public void process(Page page) {
        List<String> contentArray = page.getHtml().xpath(contentXPath).all();
        String content = null;
        if( contentArray != null && contentArray.size() > 0) content = ChangePlainText.Html2Text(StringUtils.join(contentArray, " "));
        String title = page.getHtml().xpath(titleXPath).toString();
        if( title != null) title = ChangePlainText.Html2Text(title);
        page.putField("url", page.getUrl().toString());
        page.putField("title",title);
        page.putField("content",content);
        page.addTargetRequests(page.getHtml().links().regex(URLRegex).all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args){
        String tmp = "<h1>fuck</h1><div>hi</div>";
        System.out.println(tmp.replaceAll("<[^>]*>",""));
    }
}
