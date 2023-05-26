package com.uep.wap.dto;

import com.uep.wap.model.UserProfile;
import java.util.List;

public class NewsDTO {

    private long news_id;

    private String news;

    private List<UserProfile> users;



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

        public List<UserProfile> getUsers() {
            return users;
        }

        public void setUsers(List<UserProfile> users) {
            this.users = users;
        }

}
