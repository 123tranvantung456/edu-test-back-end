package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.QuestionRequestDTO;
import com.javaweb.edutest.dto.response.QuestionResponseDTO;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    List<QuestionResponseDTO> getQuestions();
    QuestionResponseDTO getQuestionById(long questionId);
    List<QuestionResponseDTO> getQuestionsInTest(long testId);
    long addQuestion(QuestionRequestDTO questionRequestDTO);
    long addQuestionToTest(long testId, QuestionRequestDTO questionRequestDTO);
    void addQuestionFromLibraryToTest(long testId, Map<String, List<Long>> request);
    void updateQuestion(long questionId, QuestionRequestDTO questionRequestDTO);
    void updateCategoriesOfQuestion(long questionId, List<Long> newCategoryIds);
    void deleteQuestion(long questionId);
}
