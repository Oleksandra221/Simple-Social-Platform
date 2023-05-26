package com.uep.wap.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import com.uep.wap.model.ProfileImages;

@Entity
@Table(name="Feedback")
public class Feedback {
    @Id
    @Column(name = "feedback_id")
    private int feedback_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "text")
    private String text;

    @Column(name = "question_number")
    private int question_number;

    @Column(name = "satisfaction_score")
    private String satisfaction_score;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getQuestion_number() {
        return question_number;
    }

    public void setQuestion_number(int question_number) {
        this.question_number = question_number;
    }

    public String getSatisfaction_score() {
        return satisfaction_score;
    }

    public void setSatisfaction_score(String satisfaction_score) {
        this.satisfaction_score = satisfaction_score;
    }
}


