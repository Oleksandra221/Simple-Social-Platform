package com.uep.wap.repository;

import com.uep.wap.model.ProfileImages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProfileImagesRepository extends CrudRepository<ProfileImages, Long>{

}
