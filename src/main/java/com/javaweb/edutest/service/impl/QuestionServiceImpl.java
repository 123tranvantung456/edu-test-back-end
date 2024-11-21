package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.QuestionRequestDTO;
import com.javaweb.edutest.dto.response.QuestionResponseDTO;
import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.mapper.QuestionMapper;
import com.javaweb.edutest.model.Category;
import com.javaweb.edutest.model.Question;
import com.javaweb.edutest.repository.CategoryRepository;
import com.javaweb.edutest.repository.QuestionRepository;
import com.javaweb.edutest.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<QuestionResponseDTO> getQuestions() {
        return questionMapper.toQuestionResponseDTOs(questionRepository.findAll());
    }

    @Override
    public QuestionResponseDTO getQuestionById(long questionId) {
        return questionMapper.toQuestionResponseDTO(findQuestionById(questionId));
    }

    @Override
    public long addQuestion(QuestionRequestDTO questionRequestDTO) {
        Question newQuestion = questionMapper.toQuestion(questionRequestDTO);
        addCategoriesToQuestion(questionRequestDTO.getCategoryIds(), newQuestion);
        setQuestionToChoices(newQuestion);
        questionRepository.save(newQuestion);
        return newQuestion.getId();
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
}