package com.uep.wap.controller;

import com.uep.wap.dto.ProfileImagesDTO;
import com.uep.wap.model.ProfileImages;
import com.uep.wap.service.ProfileImagesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProfileImageController {

    private final ProfileImagesService profileImagesService;

    public ProfileImageController(ProfileImagesService profileImagesService) {
        this.profileImagesService = profileImagesService;
    }

    @GetMapping(path = "/profile_images")
    public Iterable<ProfileImages> getAllProfileImages(){
        return profileImagesService.getAllProfileImages();
    }

    @PostMapping(path = "/profile_images")
    public String addEmojis(@RequestBody ProfileImagesDTO profileImagesDTO){
        profileImagesService.addProfileImage(profileImagesDTO);
        return "Profile images added!";
    }

//    @PostMapping(path = "/background_image")
//    public String updateBac(BackgroundImageDTO backgroundImageDTO){
//        BackgroundImage background_image = bac.findById(backgroundImageDTO.getId()).get();
//
//        backgroundImageService.addBackgroundImage(backgroundImageDTO);
//        return "Students added!";
//    }
}
