package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.request.CommentRequestDTO;
import com.javaweb.edutest.dto.request.ReplyCommentRequestDTO;
import com.javaweb.edutest.dto.request.RootCommentRequestDTO;
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

    @GetMapping("/{commentId}")
    public ResponseData<?> getReplyComment(@PathVariable long commentId) {
        try {
            return new ResponseData<>(commentService.getComment(commentId), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("/root-comment/test/{testId}")
    public ResponseData<?> getRootCommentsInTest(@PathVariable long testId) {
        try {
            return new ResponseData<>(commentService.getRootCommentsInTest(testId), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("/reply-comment/test/{testId}")
    public ResponseData<?> getReplyComments(@PathVariable long testId) {
        try {
            return new ResponseData<>(commentService.getReplyCommentsOfCurrentComment(testId), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }


    @PostMapping("/reply-comment")
    public ResponseData<?> addReplyComment(@RequestBody ReplyCommentRequestDTO replyCommentRequestDTO) {
        try {
            return new ResponseData<>(commentService.addReplyComment(replyCommentRequestDTO), HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping("/root-comment")
    public ResponseData<?> addRootComment(@RequestBody RootCommentRequestDTO rootCommentRequestDTO) {
        try {
            return new ResponseData<>(commentService.addRootComment(rootCommentRequestDTO), HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PatchMapping("/{commentId}")
    public ResponseData<Void> updateComment(@PathVariable long commentId, @RequestBody CommentRequestDTO commentRequestDTO) {
        try {
            commentService.updateComment(commentId, commentRequestDTO);
            return new ResponseData<>(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.getReasonPhrase());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @DeleteMapping("/{commentId}")
    public ResponseData<Void> deleteComment(@PathVariable long commentId) {
        try {
            commentService.deleteComment(commentId);
            return new ResponseData<>(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
}