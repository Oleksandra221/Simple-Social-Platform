package com.uep.wap.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Followers")
public class Followers {
    @Id
    @Column(name = "user_id")
    private long user_id;
    @Column(name = "followers")
    private List<int> followers;

    @OneToOne()
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public List<int> getFollowers() {
        return followers;
    }

    public void setFollowers(List<int> followers) {
        this.followers = followers;
    }

    public UserProfile getUsers() {
        return userProfile;
    }

    public void setUsers(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}