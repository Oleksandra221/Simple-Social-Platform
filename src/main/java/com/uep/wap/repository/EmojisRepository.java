package com.uep.wap.repository;

import com.uep.wap.model.Emojis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmojisRepository extends CrudRepository<Emojis, Long> {
}