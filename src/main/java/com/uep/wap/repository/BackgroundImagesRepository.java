package com.uep.wap.repository;

import com.uep.wap.model.BackgroundImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundImagesRepository extends CrudRepository<BackgroundImage, Long> {
}
