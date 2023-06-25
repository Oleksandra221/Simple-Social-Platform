package com.uep.wap.controller;

import com.uep.wap.dto.PostImageDTO;
import com.uep.wap.model.PostImage;
import com.uep.wap.service.PostImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PostImageController {

    private final PostImageService postImageService;

    public PostImageController(PostImageService postImageService) {
        this.postImageService = postImageService;
    }

    @GetMapping(path = "/post_images")
    public Iterable<PostImage> getAllPostImages(){
        return postImageService.getAllPostImages();
    }

    @PostMapping(path = "/post_images")
    public String addEmojis(@RequestBody PostImageDTO postImageDTO){
        postImageService.addPostImage(postImageDTO);
        return "Post images added!";
    }
}
