package org.example.strategy;

import org.example.QuestionStatistics;

import java.util.List;

public interface AnalyzeStrategy {//Каждая стратегия должна реализовывать метод makeAnalyze(List<QuestionStatistics> questionStatisticsList) из
    //интерфейса AnalyzeStrategy.

    void makeAnalyze(List<QuestionStatistics> questionStatisticsList);
}
