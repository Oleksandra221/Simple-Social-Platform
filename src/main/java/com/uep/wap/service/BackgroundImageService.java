package com.uep.wap.service;

import com.uep.wap.dto.BackgroundImageDTO;
import com.uep.wap.model.BackgroundImage;
import com.uep.wap.repository.BackgroundImagesRepository;
import org.springframework.stereotype.Service;

@Service
public class BackgroundImageService {

    private BackgroundImagesRepository backgroundImagesRepository;

    // To DO: to figure out how to add emojis
    public void addBackgroundImage(BackgroundImageDTO background_image_dto) {
        BackgroundImage background_images = new BackgroundImage();
        background_images.setId(background_image_dto.getId());
        background_images.setBackground_image(background_image_dto.getBackground_image());
        background_images.setUserProfile(background_image_dto.getUserProfile());

        backgroundImagesRepository.save(background_images);
        System.out.println("Background image added!");
    }

    public Iterable<BackgroundImage> getAllBackgroundImages() {
        return backgroundImagesRepository.findAll();
    }
}
