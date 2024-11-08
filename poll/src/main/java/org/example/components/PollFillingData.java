package org.example.components;

import java.util.List;
/**
 *
 * Результат заполнения опроса пользователем
 * @param userLogin логин пользователя
 * @param pollQuestionResponseList список ответов пользователя
 */
public record PollFillingData(
        String userLogin,
        List<PollQuestionResponse> pollQuestionResponseList
) {
}