package org.zcy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.zcy.entity.CrawlTemplate;
import org.zcy.entity.Task;

import java.util.List;

/**
 * Created by zcy on 2017/2/9.
 */
@RepositoryRestResource(collectionResourceRel = "Task", path = "Task")
public interface TaskResource extends PagingAndSortingRepository<Task, Long> {
    List<Task> findByStatus(Long status);
}