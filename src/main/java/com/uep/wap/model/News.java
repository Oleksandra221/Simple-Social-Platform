package com.uep.wap.model;
import javax.persistence.*;

@Entity
@Table(name="News")
public class News {
    @Id
    @Column(name = "news_id")
    private long news_id;
    @Column(name = "news")
    private String news;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    public News() {
    }

    public long getNews_id() {
        return news_id;
    }

    public void setNews_id(long news_id) {
        this.news_id = news_id;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public UserProfile getUsers() {
        return this.userProfile;
    }

    public void setUsers(UserProfile users) {
        this.userProfile = users;
    }
}