package org.example.components;

import java.util.List;

public class PollQuestionResponse {
    private PollQuestion pollQuestion;
    private List<String> selectedVariants;

    public PollQuestion getPollQuestion() {
        return pollQuestion;
    }

    public void setPollQuestion(PollQuestion pollQuestion) {
        this.pollQuestion = pollQuestion;
    }

    public List<String> getSelectedVariants() {
        return selectedVariants;
    }

    public void setSelectedVariants(List<String> selectedVariants) {
        this.selectedVariants = selectedVariants;
    }
}
