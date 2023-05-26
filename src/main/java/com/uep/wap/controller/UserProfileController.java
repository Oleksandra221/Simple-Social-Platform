package com.uep.wap.controller;

import com.uep.wap.model.UserProfile;
import com.uep.wap.repository.UserProfileRepository;
import com.uep.wap.dto.UserProfileDTO;

import com.uep.wap.service.UserProfileService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping(path = "/users")
    public Iterable<UserProfile> getAllUsers(){
        return userProfileService.getAllUsers();
    }

    @PostMapping(path = "/users")
    public String addUsers(@RequestBody UserProfileDTO userProfileDTO){
        userProfileService.addUser(userProfileDTO);
        return "Students added!";
    }

//    @PostMapping(path = "/students")
//    public String updateStudents(StudentDTO studentDTO){
//        Student student = studentRepository.findById(studentDTO.getId()).get();
//
//        studentsService.addStudent(studentDTO);
//        return "Students added!";
//    }

}