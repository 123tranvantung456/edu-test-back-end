package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.CommentRequestDTO;
import com.javaweb.edutest.dto.response.CommentResponseDTO;

import java.util.List;

public interface CommentService {
    List<CommentResponseDTO> getComments();
    CommentResponseDTO getComment(long commentId);
    List<CommentResponseDTO> getCommentsInTest(long testId);
    long addComment(CommentRequestDTO commentRequestDTO);
    void updateComment(CommentRequestDTO commentRequestDTO);
    void deleteComment(long id);
}
