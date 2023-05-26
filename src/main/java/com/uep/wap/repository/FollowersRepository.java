package com.uep.wap.repository;

import com.uep.wap.model.Emojis;
import com.uep.wap.model.Followers;
import org.springframework.data.repository.CrudRepository;

public interface FollowersRepository extends CrudRepository<Followers, Long> {
}
