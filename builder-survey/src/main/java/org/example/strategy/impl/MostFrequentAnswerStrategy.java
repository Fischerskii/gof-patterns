package org.example.strategy.impl;

import org.example.QuestionStatistics;
import org.example.strategy.AnalyzeStrategy;

import java.util.List;
import java.util.Map;

public class MostFrequentAnswerStrategy implements AnalyzeStrategy {

    @Override
    public void makeAnalyze(List<QuestionStatistics> questionStatisticsList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----Most Frequent Analyze-----\n");

        for (QuestionStatistics questionStatistics : questionStatisticsList) {
            stringBuilder.append("Question: ")
                    .append(questionStatistics.questionTitle())
                    .append("\n");

            questionStatistics.selectedVariantsCount().entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .ifPresent(entry -> stringBuilder.append("The most frequent answer is: ")
                            .append(entry.getKey())
                            .append("\n")
                            .append(entry.getValue())
                            .append(" choose this variant")
                            .append("\n\n")
                    );
        }
        System.out.println(stringBuilder);
    }
    //должен выводить наиболее популярные ответы.
}
