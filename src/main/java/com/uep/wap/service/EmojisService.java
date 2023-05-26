package com.uep.wap.service;

import com.uep.wap.dto.EmojisDTO;
import com.uep.wap.model.Emojis;
import com.uep.wap.repository.EmojisRepository;
import org.springframework.stereotype.Service;

@Service
public class EmojisService {
    private EmojisRepository emojisRepository;

    // To DO: to figure out how to add emojis
    public void addEmoji(EmojisDTO emojisDTO) {
        Emojis emojis = new Emojis();
        emojis.setSet_emoji_name(emojisDTO.getSet_emoji_name());
        emojis.setPrice(emojisDTO.getPrice());
        emojis.setPrice(emojisDTO.getPrice());

        emojisRepository.save(emojis);
        System.out.println("Emojis added!");
    }

    public Iterable<Emojis> getAllEmojis() {
        return emojisRepository.findAll();
    }
}
