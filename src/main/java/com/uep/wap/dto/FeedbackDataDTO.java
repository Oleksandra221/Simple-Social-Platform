package com.uep.wap.dto;

import java.util.List;

public class FeedbackDataDTO {

    List<FeedbackDTO> feedback;

    public List<FeedbackDTO> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<FeedbackDTO> feedback) {
        this.feedback = feedback;
    }
}
