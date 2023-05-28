package com.uep.wap.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import com.uep.wap.model.ProfileImages;



@Entity
@Table(name="userProfile")
public class UserProfile{

    public enum Zodiac_sign {ARIES, TAURUS, GEMINI, CANCER, LEO, VIRGO, LIBRA, SCORPIO, SAGITTARIUS, CAPRICORN, AQUARIUS, PISCES}

    @Id
    @Column(name ="id")
    private long id;
    @Column(name ="username")
    private String username;

    @Column(name ="description")
    private String description;
    @Column(name ="isPremiumAccount")
    private boolean isPremiumAccount;

    @Column(name ="birthDate")
    private Date birthDate;

    @Column(name ="email")
    private String email;

    @Column(name ="password")
    private String password; // zaimplementowac haszowanie hasla

    @Column(name ="zodiac_sign")
    private Zodiac_sign zodiac_sign;

//    @ManyToOne
//    @JoinColumn(name = "emojis_id")
//    private Emojis emojis;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "emojis",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "emoji_id"))
    private List<Emojis> emojis;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<ProfileImages> profile_images;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<PostImage> post_images;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<BackgroundImage> background_images;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
//    @JoinTable(name = "news",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "news_id"))
    private List<News> news;

    @OneToOne(mappedBy = "userProfile",cascade = CascadeType.ALL)
    public Followers followers;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public UserProfile(){
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPremiumAccount() {
        return isPremiumAccount;
    }

    public void setPremiumAccount(boolean premiumAccount) {
        isPremiumAccount = premiumAccount;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Emojis> getEmojis() {
        return emojis;
    }

    public void setEmojis(List<Emojis> emojis) {
        this.emojis = emojis;
    }

    public List<ProfileImages> getProfile_images() {
        return profile_images;
    }

    public void setProfile_images(List<ProfileImages> profile_images) {
        this.profile_images = profile_images;
    }
    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Followers getFollowers() {
        return followers;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
    }
}



