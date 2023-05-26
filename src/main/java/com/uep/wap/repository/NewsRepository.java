package com.uep.wap.repository;

import com.uep.wap.model.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
}