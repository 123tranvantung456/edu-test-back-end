package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.QuestionRequestDTO;
import com.javaweb.edutest.dto.response.QuestionResponseDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionResponseDTO> getQuestions();
    QuestionResponseDTO getQuestionById(long questionId);
    long addQuestion(QuestionRequestDTO questionRequestDTO);
    void updateQuestion(long questionId, QuestionRequestDTO questionRequestDTO);
    void updateCategoriesOfQuestion(long questionId, List<Long> newCategoryIds);
    void deleteQuestion(long questionId);
}
