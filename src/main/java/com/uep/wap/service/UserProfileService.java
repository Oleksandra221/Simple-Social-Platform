package com.uep.wap.service;

import com.uep.wap.model.UserProfile;
import com.uep.wap.repository.UserProfileRepository;
import com.uep.wap.dto.UserProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    // To DO: to figure out how to add emojis
    public void addUser(UserProfileDTO userProfileDTO) {
        UserProfile user = new UserProfile();
        user.setUsername(userProfileDTO.getUsername());
        user.setDescription(userProfileDTO.getDescription());
//        user.setPremiumAccount(userProfileDTO.getPremiumAccount());
        user.setBirthDate(userProfileDTO.getBirthDate());
        user.setEmail(userProfileDTO.getEmail());
        user.setPassword(userProfileDTO.getPassword());

        userProfileRepository.save(user);
        System.out.println("User added!");
    }

    public Iterable<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

}