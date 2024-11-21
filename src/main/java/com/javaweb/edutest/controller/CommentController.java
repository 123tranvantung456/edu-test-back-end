package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.request.CommentRequestDTO;
import com.javaweb.edutest.dto.response.ResponseData;
import com.javaweb.edutest.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseData<?> getComments() {
        try {
            return new ResponseData<>(commentService.getComments(), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("/{commentId}")
    public ResponseData<?> getComment(@PathVariable long commentId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("/test/{testId}")
    public ResponseData<?> getCommentsInTest(@PathVariable long testId) {
        try {
            return new ResponseData<>(commentService.getCommentsInTest(testId), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping
    public ResponseData<?> addComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        try {
            return new ResponseData<>(commentService.addComment(commentRequestDTO), HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PutMapping("/{commentId}")
    public ResponseData<?> updateComment(@PathVariable long commentId, @RequestBody CommentRequestDTO commentRequestDTO) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @DeleteMapping("/{commentId}")
    public ResponseData<?> deleteComment(@PathVariable long commentId) {
        try {
            return null;
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
}
