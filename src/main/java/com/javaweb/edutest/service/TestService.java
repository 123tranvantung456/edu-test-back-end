package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.QuestionRequestDTO;
import com.javaweb.edutest.dto.request.TestRequestDTO;
import java.util.List;

public interface TestService {
    List<TestRequestDTO> getTests();
    TestRequestDTO getTest(long testId);
    List<QuestionRequestDTO> getQuestionsInTest(long testId);
    long addTest();
    void updateTest(long testId, TestRequestDTO test);
    void deleteTest(long testId);
}
