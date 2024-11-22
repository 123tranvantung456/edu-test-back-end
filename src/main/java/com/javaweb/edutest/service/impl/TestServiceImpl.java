package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.QuestionRequestDTO;
import com.javaweb.edutest.dto.request.TestRequestDTO;
import com.javaweb.edutest.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public List<TestRequestDTO> getTests() {
        return List.of();
    }

    @Override
    public TestRequestDTO getTest(long testId) {
        return null;
    }

    @Override
    public List<QuestionRequestDTO> getQuestionsInTest(long testId) {
        return List.of();
    }

    @Override
    public long addTest() {
        return 0;
    }

    @Override
    public void updateTest(long testId, TestRequestDTO test) {

    }

    @Override
    public void deleteTest(long testId) {

    }
}
