package com.uep.wap.dto;

import com.uep.wap.model.UserProfile;
import java.util.List;

public class FollowersDTO {

    private long user_id;

    private int followers;

    private UserProfile userProfile;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
