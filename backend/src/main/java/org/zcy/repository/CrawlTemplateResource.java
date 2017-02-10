package org.zcy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.zcy.entity.CrawlTemplate;

import java.util.List;

/**
 * Created by zcy on 2017/2/9.
 */

@RepositoryRestResource(collectionResourceRel = "CrawlTemplate", path = "CrawlTemplate")
public interface CrawlTemplateResource extends PagingAndSortingRepository<CrawlTemplate, Long> {

}