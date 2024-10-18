package org.example.components;

import java.util.List;

public class PollFillingData {
    private final String username;
    private List<PollQuestionResponse> responses;

    public PollFillingData(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public List<PollQuestionResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<PollQuestionResponse> responses) {
        this.responses = responses;
    }
}
