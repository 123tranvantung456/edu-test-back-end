package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.TestRequestDTO;
import com.javaweb.edutest.dto.response.TestResponseDTO;
import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.mapper.TestMapper;
import com.javaweb.edutest.model.Test;
import com.javaweb.edutest.repository.TestRepository;
import com.javaweb.edutest.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestMapper testMapper;
    private final TestRepository testRepository;

    @Override
    public List<TestResponseDTO> getTests() {
        return testMapper.toTestResponseDTOs(testRepository.findAll());
    }

    @Override
    public TestResponseDTO getTest(long testId) {
        return testMapper.toTestResponseDTO(findTestById(testId));
    }

    @Override
    public long addTest(TestRequestDTO testRequestDTO) {
        var newTest = testMapper.toTest(testRequestDTO);
        testRepository.save(newTest);
        return newTest.getId();
    }

    @Override
    public void updateTest(long testId, TestRequestDTO test) {
        var currentTest = findTestById(testId);
        testMapper.updateTest(currentTest, test);
        testRepository.save(currentTest);
    }

    @Override
    public void deleteTest(long testId) {
        testRepository.deleteById(testId);
    }

    private Test findTestById(long testId){
        return testRepository.findById(testId).orElseThrow(
                () -> new ResourceNotFoundException("test not found with testId " +testId)
        );
    }
}
