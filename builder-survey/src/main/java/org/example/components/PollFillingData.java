package org.example.components;

import java.util.List;

public class PollFillingData {
    private String username;
    private List<PollQuestionResponse> responses;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<PollQuestionResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<PollQuestionResponse> responses) {
        this.responses = responses;
    }
}
