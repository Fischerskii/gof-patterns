package org.example.components;

import java.util.List;

public record PollQuestion(
        String title,
        int minAnswers,
        int maxAnswers,
        List<String> answers
) {
}
