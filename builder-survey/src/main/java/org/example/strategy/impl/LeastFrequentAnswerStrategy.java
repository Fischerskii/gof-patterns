package org.example.strategy.impl;

import org.example.QuestionStatistics;
import org.example.strategy.AnalyzeStrategy;

import java.util.List;
import java.util.Map;

public class LeastFrequentAnswerStrategy implements AnalyzeStrategy {

    @Override
    public void makeAnalyze(List<QuestionStatistics> questionStatisticsList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------Least frequent answer analyze------\n");

        for (QuestionStatistics questionStatistic : questionStatisticsList) {
            stringBuilder.append("Question: ")
                    .append(questionStatistic.questionTitle())
                    .append("\n");

            questionStatistic.selectedVariantsCount().entrySet().stream()
                    .min(Map.Entry.comparingByValue())
                    .ifPresent(entry -> stringBuilder.append("The least frequent answer is: ")
                            .append(entry.getKey())
                            .append("\n")
                            .append(entry.getValue())
                            .append(" choose this variant")
                            .append("\n\n")
                    );
        }
        System.out.println(stringBuilder);
    }
    //должен выводить наименее популярные ответы.
}
