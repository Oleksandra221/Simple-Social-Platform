package com.uep.wap.dto;

import com.uep.wap.model.BackgroundImage;
import com.uep.wap.model.Emojis;
import com.uep.wap.model.PostImage;
import com.uep.wap.model.ProfileImages;

import java.sql.Date;
import java.util.List;

public class UserProfileDTO {

     private long id;

     private String name;

     private String surname;
     private String username;

     private String description;

     private boolean isPremiumAccount;

     private Date birthDate;

     private String email;

     private String password; // zaimplementowac haszowanie hasla

     private List<Emojis> emojis;

     private List<ProfileImages> profile_images;

     private List<PostImage> post_images;

     private List<BackgroundImage> background_images;

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
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
}
