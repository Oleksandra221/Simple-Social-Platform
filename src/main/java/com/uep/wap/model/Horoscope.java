package com.uep.wap.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Map;

public class Horoscope {
    @Id
    @Column(name ="horoscope_id")
    private long horoscope_id;

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

    //@Column(name = "horoscope_date")
    //private Date horoscope_date;
    @Column(name ="horoscopes")
    private Map<UserProfile.Zodiac_sign, String> horoscopes;
}
