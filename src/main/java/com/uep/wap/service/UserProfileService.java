package com.uep.wap.service;

import com.uep.wap.model.UserProfile;
import com.uep.wap.repository.UserProfileRepository;
import com.uep.wap.dto.UserProfileDTO;
import com.uep.wap.service.interfaces.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class UserProfileService implements IUserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

//    private PasswordEncoder passwordEncoder;

    // To DO: to figure out how to add emojis
    @Override
    public void addUser(UserProfileDTO userProfileDTO) {
        UserProfile user = new UserProfile();
//        user.setId(userProfileDTO.getId());
//        System.out.println("id = " + user.getId());
        user.setName(userProfileDTO.getName());
        System.out.println("name = " + user.getName());
        user.setSurname(userProfileDTO.getSurname());
        System.out.println("surname = " + user.getSurname());
        user.setUsername(userProfileDTO.getUsername());
        user.setDescription(userProfileDTO.getDescription());
//        user.setPremiumAccount(userProfileDTO.getPremiumAccount());
//        user.setBirthDate(userProfileDTO.getBirthDate());
        user.setEmail(userProfileDTO.getEmail());
        user.setPassword(userProfileDTO.getPassword());
        user.setConfirmedPassword(userProfileDTO.getConfirmedPassword());

        userProfileRepository.save(user);
        System.out.println("User added!");
    }

    @Override
    public UserProfile findUserByEmail(String email) {
        return userProfileRepository.findByEmail(email);
    }
    @Override
    public List<UserProfile> getAllUsers() {
        List<UserProfile> users_list = new ArrayList<UserProfile>();
        Iterable<UserProfile> users = userProfileRepository.findAll();
        users.forEach(users_list::add);
        return users_list;
    }

    @Override
    public void deleteUserByEmail(String email) {
        System.out.println("delete user");
         userProfileRepository.delete(findUserByEmail(email));
    }
    @Override
    public UserProfile findByUsername(String username)
    {
        return userProfileRepository.findByUsername(username);
    }
}