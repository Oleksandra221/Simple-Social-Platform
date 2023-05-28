package com.uep.wap.dto;

import com.uep.wap.model.UserProfile;

import java.util.Map;

public class HoroscopeDTO {
    private long horoscope_id;

    private Map<UserProfile.Zodiac_sign, String> horoscopes;

    public long getHoroscope_id() {
        return horoscope_id;
    }

    public void setHoroscope_id(long horoscope_id) {
        this.horoscope_id = horoscope_id;
    }

    public Map<UserProfile.Zodiac_sign, String> getHoroscopes() {
        return horoscopes;
    }

    public void setHoroscopes(Map<UserProfile.Zodiac_sign, String> horoscopes) {
        this.horoscopes = horoscopes;
    }
}
