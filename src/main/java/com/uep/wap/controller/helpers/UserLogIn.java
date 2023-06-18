package com.uep.wap.controller.helpers;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;


public class UserLogIn {

    private String email;

    private String password;

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
