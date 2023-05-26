package com.uep.wap.dto;

import com.uep.wap.model.UserProfile;

public class FeedbackDTO {

    private int feedback_id;

    private int user_id;

    private String text;

    private int question_number;

    private String satisfaction_score;

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

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
