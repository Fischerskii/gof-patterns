package org.example.components;

import java.util.List;

public class PollQuestionResponse {
    private final PollQuestion pollQuestion;
    private List<String> selectedVariants;

    public PollQuestionResponse(PollQuestion pollQuestion) {
        this.pollQuestion = pollQuestion;
    }

    public PollQuestion getPollQuestion() {
        return pollQuestion;
    }

    public List<String> getSelectedVariants() {
        return selectedVariants;
    }

    public void setSelectedVariants(List<String> selectedVariants) {
        this.selectedVariants = selectedVariants;
    }
}
