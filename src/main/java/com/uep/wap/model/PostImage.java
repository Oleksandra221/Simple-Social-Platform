package com.uep.wap.model;


import com.uep.wap.model.interfaces.Comment;

import javax.persistence.*;

@Entity
@Table(name="PostImage")
public class PostImage implements Comment {

    @Id
    @Column(name ="post_images_id")
    private Long id;
    @Column(name ="post_images")
    private String post_images;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)



    public String getPost_images() {
        return post_images;
    }

    public void setPost_images(String post_images) {
        this.post_images = post_images;
    }

    @Override
    public boolean isUserLoggedIn(UserProfile userProfile) {
        return false;
    }

    @Override
    public void leaveComment(String comment) {

    }

    @Override
    public String postComment() {
        return null;
    }

    @Override
    public void deleteComment(String comment) {

    }

    @Override
    public void editComment(String comment) {

    }

    @Override
    public void hideComment(String comment) {

    }
}
