package com.uep.wap.dto;

import java.util.List;

public class EmojisDataDTO {

    List<EmojisDTO> emojis;

    public List<EmojisDTO> getUsers() {
        return emojis;
    }

    public void setUsers(List<EmojisDTO> users) {
        this.emojis = users;
    }
}
