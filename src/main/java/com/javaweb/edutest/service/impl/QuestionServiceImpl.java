package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.QuestionRequestDTO;
import com.javaweb.edutest.dto.response.QuestionResponseDTO;
import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.mapper.QuestionMapper;
import com.javaweb.edutest.model.Category;
import com.javaweb.edutest.model.Question;
import com.javaweb.edutest.model.QuestionTest;
import com.javaweb.edutest.model.compositekey.QuestionTestPK;
import com.javaweb.edutest.repository.CategoryRepository;
import com.javaweb.edutest.repository.QuestionRepository;
import com.javaweb.edutest.repository.TestRepository;
import com.javaweb.edutest.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.*;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;
    private final TestRepository testRepository;

    @Override
    public List<QuestionResponseDTO> getQuestions() {
        return questionMapper.toQuestionResponseDTOs(questionRepository.findAll());
    }

    @Override
    public QuestionResponseDTO getQuestionById(long questionId) {
        return questionMapper.toQuestionResponseDTO(findQuestionById(questionId));
    }

    @Override
    public List<QuestionResponseDTO> getQuestionsInTest(long testId) {
        return questionMapper.toQuestionResponseDTOs(questionRepository.findByQuestionTests_Test_Id(testId));
    }

    @Override
    public long addQuestion(QuestionRequestDTO questionRequestDTO) {
        return addQuestionToDB(questionRequestDTO).getId();
    }

    @Override
    @Transactional
    public long addQuestionToTest(long testId, QuestionRequestDTO questionRequestDTO) {
        var newQuestion = addQuestionToDB(questionRequestDTO);
        var test = testRepository.findById(testId).orElseThrow(
                () -> new ResourceNotFoundException("test not found with id " +testId)
        );
        QuestionTest questionTest = QuestionTest.builder()
                .id(QuestionTestPK.builder()
                        .questionId(newQuestion.getId())
                        .testId(test.getId())
                        .build())
                .question(newQuestion)
                .test(test)
                .build();
        newQuestion.getQuestionTests().add(questionTest);
        questionRepository.save(newQuestion);
        return newQuestion.getId();
    }

    @Override
    public void addQuestionFromLibraryToTest(long testId, Map<String, List<Long>> request) {
        var test = testRepository.findById(testId).orElseThrow(
                () -> new ResourceNotFoundException("test not found with id " +testId)
        );
        List<Long> questionIds = request.get("questionIds");
        List<Question> questions = new ArrayList<>();
        questionIds.forEach(questionId -> {
            Question question = findQuestionById(questionId);
            QuestionTest questionTest = QuestionTest.builder()
                    .id(QuestionTestPK.builder()
                            .questionId(questionId)
                            .testId(test.getId())
                            .build())
                    .test(test)
                    .question(findQuestionById(questionId))
                    .build();
            question.getQuestionTests().add(questionTest);
            questions.add(findQuestionById(questionId));
        });

//        var questionTests = new ArrayList<QuestionTest>();
//        questionIds.forEach(questionId ->{
//            QuestionTest questionTest = QuestionTest.builder()
//                    .id(QuestionTestPK.builder()
//                            .questionId(questionId)
//                            .testId(test.getId())
//                            .build())
//                    .test(test)
//                    .question(findQuestionById(questionId))
//                    .build();
//            questionTests.add(questionTest);
//            }
//            );
        questionRepository.saveAll(questions);
    }

    @Override
    public void updateQuestion(long questionId, QuestionRequestDTO questionRequestDTO) {
        Question currentQuestion = findQuestionById(questionId);
        questionMapper.toQuestion(currentQuestion, questionRequestDTO);
        updateCategoriesToQuestion(questionRequestDTO.getCategoryIds(), currentQuestion);
        setQuestionToChoices(currentQuestion);
        questionRepository.save(currentQuestion);
    }

    @Override
    public void updateCategoriesOfQuestion(long questionId, List<Long> newCategoryIds) {
        Question currentQuestion = findQuestionById(questionId);
        currentQuestion.setCategories(fetchCategoryByIds(newCategoryIds));
        questionRepository.save(currentQuestion);
    }

    @Override
    public void deleteQuestion(long questionId) {
        questionRepository.deleteById(questionId);
    }

    private void addCategoriesToQuestion(List<Long> categoryIds, Question question) {
        if(categoryIds != null && !categoryIds.isEmpty()){
            var categories = fetchCategoryByIds(categoryIds);
            question.getCategories().addAll(categories);
        }
    }

    private void updateCategoriesToQuestion(List<Long> categoryIds, Question question) {
        if(categoryIds != null && !categoryIds.isEmpty()){
            var categories = fetchCategoryByIds(categoryIds);
            question.setCategories(categories);
        }
        else {
            question.getCategories().clear();
        }
    }

    private void setQuestionToChoices(Question question) {
        question.getChoices().forEach(choice -> choice.setQuestion(question));
    }

    private Set<Category> fetchCategoryByIds(List<Long> categoryIds) {
        var categories = new HashSet<Category>();
        categoryIds.forEach(categoryId -> categories.add(findCategoryById(categoryId)));
        return categories;
    }

    private Question findQuestionById(long questionId){
        return questionRepository.findById(questionId).orElseThrow(
                () -> new ResourceNotFoundException("question not found with id " + questionId)
        );
    }

    private Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category not found with id " + categoryId));
    }

    private Question addQuestionToDB(QuestionRequestDTO questionRequestDTO) {
        Question newQuestion = questionMapper.toQuestion(questionRequestDTO);
        addCategoriesToQuestion(questionRequestDTO.getCategoryIds(), newQuestion);
        setQuestionToChoices(newQuestion);
        return questionRepository.save(newQuestion);
    }
}