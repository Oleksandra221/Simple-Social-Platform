package com.uep.wap.repository;

import com.uep.wap.model.PostImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImageRepository extends CrudRepository<PostImage, Long> {
}
