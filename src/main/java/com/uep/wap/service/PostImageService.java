package com.uep.wap.service;

import com.uep.wap.dto.PostImageDTO;
import com.uep.wap.dto.ProfileImagesDTO;
import com.uep.wap.model.PostImage;
import com.uep.wap.model.ProfileImages;
import com.uep.wap.repository.PostImageRepository;
import com.uep.wap.repository.ProfileImagesRepository;
import org.springframework.stereotype.Service;

@Service
public class PostImageService {

    private PostImageRepository postImageRepository;

    // To DO: to figure out how to add emojis
    public void addPostImage(PostImageDTO post_image_dto) {
        PostImage post_images = new PostImage();
        post_images.setId(post_image_dto.getId());
        post_images.setPost_images(post_image_dto.getPost_images());
        post_images.setUserProfile(post_image_dto.getUserProfile());

        postImageRepository.save(post_images);
        System.out.println("Post image added!");
    }

    public Iterable<PostImage> getAllProfileImages() {
        return postImageRepository.findAll();
    }
}
