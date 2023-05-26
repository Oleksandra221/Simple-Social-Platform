package com.uep.wap.dto;

import com.uep.wap.model.Followers;

import java.util.List;

public class FollowersDataDTO {

    List<FollowersDTO> followers;

    public List<FollowersDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FollowersDTO> followers) {
        this.followers = followers;
    }
}
