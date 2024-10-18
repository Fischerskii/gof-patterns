package org.example;

import org.example.strategy.AnalyzeStrategy;
import org.example.dataObjects.PollFillingData;

import java.util.ArrayList;
import java.util.List;

public class PollAnalyzer {
    private AnalyzeStrategy strategy;

    public PollAnalyzer(AnalyzeStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeAnalyzeStrategy(AnalyzeStrategy strategy) {
        this.strategy = strategy;
    }

    public void analyzePoll(List<PollFillingData> pollFillingDataList) {
        List<QuestionStatistics> statistics = collectStatistics(pollFillingDataList);
        strategy.makeAnalyze(statistics);
    }

    private List<QuestionStatistics> collectStatistics(List<PollFillingData> pollFillingDataList) {
        //TODO
        return new ArrayList<>();
    }
}
