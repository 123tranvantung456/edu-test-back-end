package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.QuestionRequestDTO;
import com.javaweb.edutest.dto.request.TestRequestDTO;
import com.javaweb.edutest.dto.response.TestResponseDTO;
import com.javaweb.edutest.model.Question;

import java.util.List;

public interface TestService {
    List<TestResponseDTO> getTests();
    TestResponseDTO getTest(long testId);
    long addTest(TestRequestDTO test);
    void updateTest(long testId, TestRequestDTO test);
    void deleteTest(long testId);
}
