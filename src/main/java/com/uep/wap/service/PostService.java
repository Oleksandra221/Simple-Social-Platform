package com.uep.wap.service;

import com.uep.wap.dto.PostDTO;
import com.uep.wap.model.Post;
import com.uep.wap.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void addPost(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setUser_name(postDTO.getUser_name());
        post.setSurname(postDTO.getSurname());
        post.setContent(postDTO.getContent());

        postRepository.save(post);
        System.out.println(post.getSurname() + ": " + post.getContent());
    }
}

