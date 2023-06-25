package com.uep.wap.service;

import com.uep.wap.dto.PostDTO;
import com.uep.wap.model.Post;
import com.uep.wap.model.UserProfile;
import com.uep.wap.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        post.setEmail(postDTO.getEmail());

        postRepository.save(post);
    }
    public List<Post> findPostsByEmail(String email) {
        return postRepository.findByEmail(email);
    }

    public Post findPostsById(long id) {return postRepository.findById(id);}

    public void deletePostById(long id) {postRepository.deleteById(id);};
}

