package org.example.components;

import java.util.List;

public class PollQuestion {
    private final String title;
    private final int minAnswers;
    private final int maxAnswers;
    private final List<String> answers;

    public PollQuestion(String title, int minAnswers, int maxAnswers, List<String> answers) {
        this.title = title;
        this.minAnswers = minAnswers;
        this.maxAnswers = maxAnswers;
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "PollQuestion{" +
                "title='" + title + '\'' +
                ", answers=" + answers +
                '}';
    }

    public int getMinAnswers() {
        return minAnswers;
    }

    public int getMaxAnswers() {
        return maxAnswers;
    }
}
