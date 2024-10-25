package org.example.strategy.impl;

import org.example.QuestionStatistics;
import org.example.strategy.AnalyzeStrategy;

import java.util.List;

public class FullCountStrategy implements AnalyzeStrategy {

    @Override
    public void makeAnalyze(List<QuestionStatistics> questionStatisticsList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----Full Count Analyze-----\n");

        for (QuestionStatistics questionStatistic : questionStatisticsList) {
            stringBuilder.append("Question: ")
                    .append(questionStatistic.questionTitle())
                    .append("\n");

            int totalUserPolledCount = questionStatistic.userSelectedVariantsCount().size();

            for (var entry : questionStatistic.selectedVariantsCount().entrySet()) {
                stringBuilder.append(entry.getValue())
                        .append(" out of ")
                        .append(totalUserPolledCount)
                        .append(" chose: ")
                        .append(entry.getKey())
                        .append("\n");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
    //должен выводить статистику количества ответов по каждому варианту.
}
