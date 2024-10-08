package org.example.builders;

import org.example.Poll;
import org.example.components.PollQuestion;

import java.util.ArrayList;
import java.util.List;

public class PollBuilder {
    private String pollName;
    private final List<PollQuestion> questions;

    public PollBuilder(List<PollQuestion> questions) {
        this.questions = new ArrayList<>();
    }

    public PollBuilder withPollName(String pollName) {
        this.pollName = pollName;
        return this;
    }

    public PollQuestionBuilder pollQuestion(String title) {
        return new PollQuestionBuilder(this).withTitle(title);
    }

    public PollQuestionBuilder oneVariantPollQuestion(String title) {
        return new PollQuestionBuilder(this)
                .withTitle(title)
                .withMinAnswers(1)
                .withMaxAnswers(1);
    }

    public PollBuilder yesNoPollQuestion(String title) {
        return new PollQuestionBuilder(this)
                .withTitle(title)
                .withMinAnswers(1)
                .withMaxAnswers(1)
                .withAnswerVariant("Yes")
                .withAnswerVariant("No")
                .and();
    }

    public PollQuestionBuilder notMandatoryQuestion(String title) {
        return new PollQuestionBuilder(this)
                .withTitle(title)
                .withMinAnswers(0);
    }

    public Poll build() {
        return new Poll(pollName, questions);
    }

    public PollBuilder addQuestion(PollQuestion question) {
        questions.add(question);
        return this;
    }
}
