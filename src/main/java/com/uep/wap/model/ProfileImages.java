package com.uep.wap.model;

import com.uep.wap.model.interfaces.Comment;

import javax.persistence.*;

@Entity
@Table(name="ProfileImages")
public class ProfileImages implements Comment {
    @Id
    @Column(name ="profile_images_id")
    private Long id;

    @Column(name ="profile_image")
    private String profile_image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
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
