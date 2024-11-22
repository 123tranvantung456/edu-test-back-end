package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.response.ResponseData;
import com.javaweb.edutest.service.TestHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test-histories")
@RequiredArgsConstructor
public class TestHistoryController {
    private final TestHistoryService testHistoryService;

    @GetMapping
    public ResponseData<?> getHistories() {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("/{historyId}")
    public ResponseData<?> getHistory(@PathVariable long historyId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("user/{userId}")
    public ResponseData<?> getHistoryOfUser(@PathVariable("userId") long userId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("test/{testId}")
    public ResponseData<?> getHistoryOfTest(@PathVariable("testId") long testId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

}