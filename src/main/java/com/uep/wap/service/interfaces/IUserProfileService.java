package com.uep.wap.service.interfaces;

import com.uep.wap.dto.UserProfileDTO;
import com.uep.wap.model.UserProfile;

import java.util.List;

public interface IUserProfileService {
    public void addUser(UserProfileDTO userProfileDTO);
    public List<UserProfile> getAllUsers();

    public UserProfile findUserByEmail(String email);
    public void deleteUserByEmail(String email);

    public UserProfile findByUsername(String username);
}
