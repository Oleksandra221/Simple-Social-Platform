package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="content")
    private String content;
    @Column(name="user_name")
    private String user_name;
    @Column(name="surname")
    private String surname;

    @Column(name="email")
    private String email;

    @ManyToMany(mappedBy = "posts")
    private List<UserProfile> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return content;
    }
}
