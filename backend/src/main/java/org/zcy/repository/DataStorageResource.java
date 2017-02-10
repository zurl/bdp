package org.zcy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.zcy.entity.CrawlTemplate;
import org.zcy.entity.DataStorage;

import java.util.List;

/**
 * Created by zcy on 2017/2/9.
 */

@RepositoryRestResource(collectionResourceRel = "DataStorage", path = "DataStorage")
public interface DataStorageResource extends PagingAndSortingRepository<DataStorage, Long> {
    List<DataStorage> findByTaskId ( @Param("taskId") Long taskId );
}
