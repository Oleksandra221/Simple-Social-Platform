package com.uep.wap.dto;

import com.uep.wap.model.UserProfile;
import java.util.List;

public class EmojisDTO {

    private long emojis_id;

    private String set_emoji_name;

    private List<UserProfile> users;

    private double price;

    public long getEmojis_id() {
        return emojis_id;
    }

    public void setEmojis_id(long emojis_id) {
        this.emojis_id = emojis_id;
    }

    public String getSet_emoji_name() {
        return set_emoji_name;
    }

    public void setSet_emoji_name(String set_emoji_name) {
        this.set_emoji_name = set_emoji_name;
    }

    public List<UserProfile> getUsers() {
        return users;
    }

    public void setUsers(List<UserProfile> users) {
        this.users = users;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
