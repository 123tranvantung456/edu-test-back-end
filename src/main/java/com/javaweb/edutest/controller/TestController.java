package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.response.ResponseData;
import com.javaweb.edutest.model.Question;
import com.javaweb.edutest.model.Test;
import com.javaweb.edutest.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/tests")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

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

    @GetMapping("/{testId}/questions")
    public ResponseData<?> getQuestionsInTest(@PathVariable long testId) {
        try {
            return new ResponseData<>(testService.getTest(testId), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping
    public ResponseData<?> addTest(@RequestBody Test test) {
        try {
            return new ResponseData<>(testService.addTest(), HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping("/{testId}/questions")
    public ResponseData<?> addQuestionsToTest(@PathVariable long testId, @RequestBody List<Question> questions) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping("/{testId}/questions/from-library")
    public ResponseData<?> addQuestionsFromLibraryToTest(@PathVariable long testId, @RequestBody List<Long> questionIds) {
        try {
            return new ResponseData<>(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PutMapping("/{testId}")
    public ResponseData<?> updateTest(@PathVariable long testId, @RequestBody Test test) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @DeleteMapping
    public ResponseData<?> deleteTest(@PathVariable long testId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @DeleteMapping("/{testId}/questions")
    public ResponseData<?> updateQuestionsInTest(@PathVariable long testId, @RequestBody List<Question> questions) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
}
