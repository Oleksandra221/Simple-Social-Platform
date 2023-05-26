package com.uep.wap.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Emojis")
public class Emojis {
    @Id
    @Column(name ="emojis_id")
    private long emojis_id;
    @Column(name ="set_emoji_name")
    private String set_emoji_name;

//    @Column(name ="accessability")
//    @ManyToMany(mappedBy = "emojis", cascade = CascadeType.ALL) // ?????????????????
//    private List<UserProfile> accessability; // list of users who have an access to the set of emojis
    @ManyToMany(mappedBy = "emojis")
    private List<UserProfile> users;
    @Column(name ="price")
    private double price;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public long getEmojis_id() {
        return emojis_id;
    }

    public void setEmojis_id(long emojis_id) {
        this.emojis_id = emojis_id;
    }

    public String getSet_emoji_name() {
        return set_emoji_name;
    }

    public void setSet_emoji_name(String set_emoji_name) {
        this.set_emoji_name = set_emoji_name;
    }

    public List<UserProfile> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserProfile> users) {
        this.users = users;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
