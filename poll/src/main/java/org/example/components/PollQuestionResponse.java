package org.example.components;

import java.util.List;

/**
 * Ответ на вопрос опроса
 *
 * @param pollQuestion     вопрос
 * @param selectedVariants выбранные варианты ответа
 */
public record PollQuestionResponse(
        PollQuestion pollQuestion,
        List<String> selectedVariants
) {
}
