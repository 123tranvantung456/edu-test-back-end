package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.request.QuestionRequestDTO;
import com.javaweb.edutest.dto.request.TestRequestDTO;
import com.javaweb.edutest.dto.response.ResponseData;
import com.javaweb.edutest.model.Question;
import com.javaweb.edutest.model.Test;
import com.javaweb.edutest.service.QuestionService;
import com.javaweb.edutest.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/tests")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    private final QuestionService questionService;

    @GetMapping
    public ResponseData<?> getTests() {
        try {
            return new ResponseData<>(testService.getTests(), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("/{testId}")
    public ResponseData<?> getTest(@PathVariable long testId) {
        try {
            return new ResponseData<>(testService.getTest(testId), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping
    public ResponseData<?> addTest(@RequestBody TestRequestDTO testRequestDTO) {
        try {
            return new ResponseData<>(testService.addTest(testRequestDTO), HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping("/{testId}/question")
    public ResponseData<?> addQuestionsToTest(@PathVariable long testId, @RequestBody QuestionRequestDTO questionRequestDTO) {
        try {
            return new ResponseData<>(questionService.addQuestionToTest(testId, questionRequestDTO), HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping("/{testId}/questions/from-library")
    public ResponseData<?> addQuestionsFromLibraryToTest(@PathVariable long testId, @RequestBody Map<String, List<Long>> request) {
        try {
            questionService.addQuestionFromLibraryToTest(testId, request);
            return new ResponseData<>(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PutMapping("/{testId}")
    public ResponseData<?> updateTest(@PathVariable long testId, @RequestBody TestRequestDTO testRequestDTO) {
        try {
            testService.updateTest(testId, testRequestDTO);
            return new ResponseData<>(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @DeleteMapping("/{testId}")
    public ResponseData<?> deleteTest(@PathVariable long testId) {
        try {
            testService.deleteTest(testId);
            return new ResponseData<>(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @DeleteMapping("/{testId}/question/{questionId}")
    public ResponseData<?> updateQuestionsInTest(@PathVariable long testId, @PathVariable long questionId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
}
