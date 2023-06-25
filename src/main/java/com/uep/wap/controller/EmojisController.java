package com.uep.wap.controller;

import com.uep.wap.dto.EmojisDTO;
import com.uep.wap.model.Emojis;
import com.uep.wap.service.EmojisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class EmojisController {

    private final EmojisService emojisService;

    public EmojisController(EmojisService emojisService) {
        this.emojisService = emojisService;
    }

    @GetMapping(path = "/emoji")
    public Iterable<Emojis> getAllEmojis(){
        return emojisService.getAllEmojis();
    }

    @PostMapping(path = "/emoji")
    public String addEmojis(@RequestBody EmojisDTO emojisDTO){
        emojisService.addEmoji(emojisDTO);
        return "emoji added!";
    }
}
