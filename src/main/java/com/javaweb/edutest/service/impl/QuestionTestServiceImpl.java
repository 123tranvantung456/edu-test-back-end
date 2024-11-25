package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.model.Question;
import com.javaweb.edutest.model.QuestionTest;
import com.javaweb.edutest.model.Test;
import com.javaweb.edutest.model.compositekey.QuestionTestPK;
import com.javaweb.edutest.repository.QuestionRepository;
import com.javaweb.edutest.repository.QuestionTestRepository;
import com.javaweb.edutest.repository.TestRepository;
import com.javaweb.edutest.service.QuestionTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionTestServiceImpl implements QuestionTestService {
    private final TestRepository testRepository;
    private final QuestionRepository questionRepository;
    private final QuestionTestRepository questionTestRepository;

    @Override
    public void addQuestionToTest(long questionId, long testId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new RuntimeException("Test not found"));

        QuestionTest questionTest = QuestionTest.builder()
                .id(QuestionTestPK.builder()
                        .questionId(question.getId())
                        .testId(test.getId())
                        .build())
                .question(question)
                .test(test)
                .build();
        questionTestRepository.save(questionTest);
    }
}
