package org.example;

import java.util.Map;

public record QuestionStatistics(
        String questionTitle,
        Map<String, Integer> selectedVariantsCount,
        Map<String, Integer> userSelectedVariantsCount
) {
}
