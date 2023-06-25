package com.uep.wap.controller;

import com.uep.wap.dto.BackgroundImageDTO;
import com.uep.wap.model.BackgroundImage;
import com.uep.wap.service.BackgroundImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BackgroundImageController {
    private final BackgroundImageService backgroundImageService;

    public BackgroundImageController(BackgroundImageService backgroundImageService) {
        this.backgroundImageService = backgroundImageService;
    }

    @GetMapping(path = "/background_image")
    public Iterable<BackgroundImage> getAllBackgroundImages(){
        return backgroundImageService.getAllBackgroundImages();
    }

    @PostMapping(path = "/background_image")
    public String addUsers(@RequestBody BackgroundImageDTO backgroundImageDTO){
        backgroundImageService.addBackgroundImage(backgroundImageDTO);
        return "Background image added!";
    }

}
