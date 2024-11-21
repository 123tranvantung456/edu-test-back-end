package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.response.ResponseData;
import com.javaweb.edutest.model.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tests")
public class TestController {
    @GetMapping
    public ResponseData<?> getTests() {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
    @GetMapping("/{testId}")
    public ResponseData<?> getTest(@PathVariable long testId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
    @GetMapping("/{testId}/questions")
    public ResponseData<?> getQuestionsInTest(@PathVariable long testId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
    @PostMapping
    public ResponseData<?> addTest(@RequestBody Test test) {
        try {
            return null;
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
//    @PostMapping("/{testId}/questions")
//    public ResponseData<?> addQuestionIoTest(@PathVariable long testId,
//                                             @RequestBody Map<String, List<Long>> request) {
//        try {
//            return null;
//        } catch (Exception e) {
//            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
//        }
//    }
//    @PutMapping("/{testId}/questions")
//    public ResponseData<?> updateQuestionInTest(@PathVariable long testId,
//                                             @RequestBody Map<String, List<Long>> request) {
//        try {
//            return null;
//        } catch (Exception e) {
//            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
//        }
//    }

    @DeleteMapping
    public ResponseData<?> deleteTest(@PathVariable long testId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
}
