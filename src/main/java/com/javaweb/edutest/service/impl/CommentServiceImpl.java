package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.CommentRequestDTO;
import com.javaweb.edutest.dto.response.CommentResponseDTO;
import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.mapper.CommentMapper;
import com.javaweb.edutest.model.Comment;
import com.javaweb.edutest.model.RootComment;
import com.javaweb.edutest.model.Test;
import com.javaweb.edutest.model.User;
import com.javaweb.edutest.repository.*;
import com.javaweb.edutest.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final RootCommentRepository rootCommentRepository;
    private final ReplyCommentRepository replyCommentRepository;
    private final CommentRepository commentRepository;
    private final UserRepository UserRepository;
    private final TestRepository testRepository;

    @Override
    public List<CommentResponseDTO> getComments() {
        return commentMapper.toCommentResponseDTOList(rootCommentRepository.findAll());
    }

    @Override
    public CommentResponseDTO getComment(long commentId) {
        return commentMapper.toCommentResponseDTO(findCommentById(commentId));
    }

    @Override
    public List<CommentResponseDTO> getCommentsInTest(long testId) {
        List<RootComment> commentCurrent = rootCommentRepository.findByTest_IdOrderByIdAsc(testId);
        List<CommentResponseDTO> results = commentMapper.toCommentResponseDTOList(commentCurrent);
        results.forEach(commentResponseDTO -> commentResponseDTO.setSubCommentCount(
                replyCommentRepository.countByParentComment_Id(commentResponseDTO.getId())));
        return results;
    }

    @Override
    public long addComment(CommentRequestDTO commentRequestDTO) {
//        Comment newComment = commentMapper.toComment(commentRequestDTO);
//        newComment.setAuthor(findUser(1L));
//        newComment.setParentComment(findCommentById(commentRequestDTO.getParentId()));
//        commentRepository.save(newComment);
//        return newComment.getId();
        return 1;
    }

    @Override
    public void updateComment(CommentRequestDTO commentRequestDTO) {

    }

    @Override
    public void deleteComment(long commentId) {
        commentRepository.deleteById(commentId);
    }

    private void addReplyCommentCountToRootCommentResponseDTO(List<RootComment> rootComment) {
        
    }

    private Test findTestById(long testId) {
        return testRepository.findById(testId).orElseThrow(
                () -> new ResourceNotFoundException("test not found with id : " +testId)
        );
    }

    private Comment findCommentById(long commentId) {
        return commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("comment not found with id : " +commentId)
        );
    }

    private User findUser(long id) {
        return UserRepository.findById(id).get();
    }
}
