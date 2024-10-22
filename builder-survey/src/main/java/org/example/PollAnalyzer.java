package org.example;

import org.example.components.PollFillingData;
import org.example.components.PollQuestionResponse;
import org.example.strategy.AnalyzeStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, QuestionStatistics> questionStatisticsMap = new HashMap<>();

        for (PollFillingData pollFillingData : pollFillingDataList) {
            for (PollQuestionResponse pollQuestionResponse : pollFillingData.pollQuestionResponseList()) {
                String questionTitle = pollQuestionResponse.pollQuestion().title();
                List<String> selectedVariants = pollQuestionResponse.selectedVariants();

                questionStatisticsMap.putIfAbsent(questionTitle, new QuestionStatistics(
                        questionTitle,
                        new HashMap<>(),
                        new HashMap<>())
                );

                QuestionStatistics questionStatistics = questionStatisticsMap.get(questionTitle);

                for (String selectedVariant : selectedVariants) {
                    Map<String, Integer> selectedVariantsCount = questionStatistics.selectedVariantsCount();

                    selectedVariantsCount.put(
                            selectedVariant,
                            selectedVariantsCount.containsKey(selectedVariant)
                                    ? selectedVariantsCount.get(selectedVariant) + 1
                                    : 1
                    );
                }

                String userLogin = pollFillingData.userLogin();
                Map<String, Integer> userSelectedVariantsCount = questionStatistics.userSelectedVariantsCount();

                userSelectedVariantsCount.put(userLogin, userSelectedVariantsCount.containsKey(userLogin)
                        ? userSelectedVariantsCount.get(userLogin) + 1
                        : 1
                );
            }
        }

        return new ArrayList<>(questionStatisticsMap.values());
    }
}
