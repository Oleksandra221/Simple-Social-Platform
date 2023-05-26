package com.uep.wap.dto;

import com.uep.wap.model.Emojis;

import java.sql.Date;
import java.util.List;

public class UserProfileDTO {

     private long id;

     private String username;

     private String description;

     private boolean isPremiumAccount;

     private Date birthDate;

     private String email;

     private String password; // zaimplementowac haszowanie hasla

     private List<Emojis> emojis;

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
}
