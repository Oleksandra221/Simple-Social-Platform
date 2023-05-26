package com.uep.wap.dto;

import com.uep.wap.model.UserProfile;

public class PostImageDTO {

    private Long id;
    private String post_images;
    private UserProfile userProfile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost_images() {
        return post_images;
    }

    public void setPost_images(String post_images) {
        this.post_images = post_images;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
