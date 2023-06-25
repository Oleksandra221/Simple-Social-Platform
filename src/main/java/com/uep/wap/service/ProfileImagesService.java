package com.uep.wap.service;

import com.uep.wap.dto.EmojisDTO;
import com.uep.wap.dto.ProfileImagesDTO;
import com.uep.wap.model.ProfileImages;
import com.uep.wap.repository.ProfileImagesRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileImagesService {
    private ProfileImagesRepository profileImagesRepository;

    public void addProfileImage(ProfileImagesDTO profile_image_dto) {
        ProfileImages profile_images = new ProfileImages();
        profile_images.setId(profile_image_dto.getId());
        profile_images.setProfile_image(profile_image_dto.getProfile_image());
        profile_images.setUserProfile(profile_image_dto.getUserProfile());

        profileImagesRepository.save(profile_images);
    }

    public Iterable<ProfileImages> getAllProfileImages() {
        return profileImagesRepository.findAll();
    }
}
