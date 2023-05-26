package com.uep.wap.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import com.uep.wap.model.ProfileImages;

@Entity
@Table(name="userProfile")
public class UserProfile{
    @Id
    @Column(name ="id")
    private long id;
    @Column(name ="user_name")
    private String name;
    @Column(name ="user_surname")
    private String surname;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public UserProfile(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<PostImage> getPost_images() {
        return post_images;
    }

    public void setPost_images(List<PostImage> post_images) {
        this.post_images = post_images;
    }

    public List<BackgroundImage> getBackground_images() {
        return background_images;
    }

    public void setBackground_images(List<BackgroundImage> background_images) {
        this.background_images = background_images;
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
}



