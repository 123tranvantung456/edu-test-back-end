package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.QuestionRequestDTO;
import com.javaweb.edutest.dto.response.QuestionResponseDTO;
import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.mapper.QuestionMapper;
import com.javaweb.edutest.model.Question;
import com.javaweb.edutest.model.QuestionTest;
import com.javaweb.edutest.model.compositekey.QuestionTestPK;
import com.javaweb.edutest.repository.CategoryRepository;
import com.javaweb.edutest.repository.QuestionRepository;
import com.javaweb.edutest.repository.TestRepository;
import com.javaweb.edutest.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Primary
@Service
@RequiredArgsConstructor
public class TestImpl implements QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;
    private final TestRepository testRepository;

    @Override
    public List<QuestionResponseDTO> getQuestions() {
        return null;
    }

    @Override
    public QuestionResponseDTO getQuestionById(long questionId) {
        return null;
    }

    @Override
    public List<QuestionResponseDTO> getQuestionsInTest(long testId) {
        return List.of();
    }

    @Override
    public long addQuestion(QuestionRequestDTO questionRequestDTO) {
        return 0;
    }

    @Override
    public long addQuestionToTest(long testId, QuestionRequestDTO questionRequestDTO) {
        return 0;
    }

    @Override
    public void addQuestionFromLibraryToTest(long testId, Map<String, List<Long>> request) {
        var test = testRepository.findById(testId).orElseThrow(
                () -> new ResourceNotFoundException("test not found with id " +testId)
        );
        List<Long> questionIds = request.get("questionIds");
        var questionTests = new ArrayList<QuestionTest>();
        questionIds.forEach(questionId ->{
            QuestionTest questionTest = QuestionTest.builder()
                    .id(QuestionTestPK.builder()
                            .questionId(questionId)
                            .testId(test.getId())
                            .build())
                    .test(test)
                    .question(findQuestionById(questionId))
                    .build();
            questionTests.add(questionTest);
            }
            );
        test.getQuestionTests().addAll(questionTests);
        testRepository.save(test);
    }

    private Question findQuestionById(long questionId){
        return questionRepository.findById(questionId).orElseThrow(
                () -> new ResourceNotFoundException("question not found with id " + questionId)
        );
    }


    @Override
    public void updateQuestion(long questionId, QuestionRequestDTO questionRequestDTO) {

    }

    @Override
    public void updateCategoriesOfQuestion(long questionId, List<Long> newCategoryIds) {

    }

    @Override
    public void deleteQuestion(long questionId) {

    }
}
