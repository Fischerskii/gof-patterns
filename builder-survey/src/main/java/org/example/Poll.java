package org.example;

import org.example.builders.PollBuilder;
import org.example.components.PollQuestion;

import java.util.ArrayList;
import java.util.List;

public class Poll {
    private String pollName;
    private List<PollQuestion> pollQuestionList;

    public Poll(String pollName, List<PollQuestion> pollQuestionList) {
        this.pollName = pollName;
        this.pollQuestionList = pollQuestionList;
    }

    public static PollBuilder builder() {
        List<PollQuestion> pollQuestionList = new ArrayList<>();
        return new PollBuilder(pollQuestionList);
    }

    public String getPollName() {
        return pollName;
    }

    public void setPollName(String pollName) {
        this.pollName = pollName;
    }

    public List<PollQuestion> getPollQuestionList() {
        return pollQuestionList;
    }

    public void setPollQuestionList(List<PollQuestion> pollQuestionList) {
        this.pollQuestionList = pollQuestionList;
    }
}
