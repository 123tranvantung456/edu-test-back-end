package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.CommentRequestDTO;
import com.javaweb.edutest.dto.request.ReplyCommentRequestDTO;
import com.javaweb.edutest.dto.request.RootCommentRequestDTO;
import com.javaweb.edutest.dto.response.CommentResponseDTO;

import java.util.List;

public interface CommentService {
    CommentResponseDTO getComment(long commentId);
    List<CommentResponseDTO> getRootCommentsInTest(long testId);
    List<CommentResponseDTO> getReplyCommentsOfCurrentComment(long currentCommentId);
    long addReplyComment(ReplyCommentRequestDTO replyCommentRequestDTO);
    long addRootComment(RootCommentRequestDTO rootCommentRequestDTO);
    void updateComment(long commentId, CommentRequestDTO commentRequestDTO);
    void deleteComment(long id);
}