package org.example.builders;

import org.example.components.PollQuestion;

import java.util.ArrayList;
import java.util.List;

public class PollQuestionBuilder {
    private final PollBuilder pollBuilder;
    private String title;
    private int minAnswers;
    private int maxAnswers;
    private final List<String> answers;

    public PollQuestionBuilder(PollBuilder pollBuilder) {
        this.pollBuilder = pollBuilder;
        this.title = "Empty title";
        this.minAnswers = 0;
        this.maxAnswers = 0;
        this.answers = new ArrayList<>();
    }

    public PollQuestionBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public PollQuestionBuilder withMinAnswers(int minAnswers) {
        this.minAnswers = minAnswers;
        return this;
    }

    public PollQuestionBuilder withMaxAnswers(int maxAnswers) {
        this.minAnswers = maxAnswers;
        return this;
    }

    public PollQuestionBuilder withAnswerVariant(String answerVariant) {
        answers.add(answerVariant);
        return this;
    }

    public PollBuilder and() {
        PollQuestion pollQuestion = this.buildQuestion();
        return pollBuilder.addQuestion(pollQuestion);
    }

    private PollQuestion buildQuestion() {
        return new PollQuestion(title, minAnswers, maxAnswers, answers);
    }
}
