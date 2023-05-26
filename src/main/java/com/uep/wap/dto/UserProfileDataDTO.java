package com.uep.wap.dto;

import java.util.List;

public class UserProfileDataDTO {

    List<UserProfileDTO> users;

    public List<UserProfileDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserProfileDTO> users) {
        this.users = users;
    }
}