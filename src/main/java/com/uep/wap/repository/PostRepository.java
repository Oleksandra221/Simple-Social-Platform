package com.uep.wap.repository;

import com.uep.wap.model.Post;
import com.uep.wap.model.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByEmail(String email);
    Post findById(long id);
    void deleteById(long id);

}
