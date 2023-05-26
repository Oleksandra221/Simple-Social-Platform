package com.uep.wap.model;

import com.uep.wap.model.interfaces.Comment;
import com.uep.wap.model.interfaces.Image;

import javax.persistence.*;

@Entity
@Table(name="BackgroundImage")
public class BackgroundImage implements Comment {

    @Id
    @Column(name ="post_images_id")
    private Long id;

    @Column(name ="background_image")
    private String background_image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
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
