package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.request.CategoryRequestDTO;
import com.javaweb.edutest.dto.response.ResponseData;
import com.javaweb.edutest.service.QuestionTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/question-tests")
public class QuestionTestController {

    private final QuestionTestService questionTestService;

    @PostMapping("question/{questionId}/test/{testId}")
    public void addQuestionToTest(@PathVariable long questionId, @PathVariable long testId) {
        questionTestService.addQuestionToTest(questionId, testId);

    }
}
