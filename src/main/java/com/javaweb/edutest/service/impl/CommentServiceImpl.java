package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.CommentRequestDTO;
import com.javaweb.edutest.dto.request.ReplyCommentRequestDTO;
import com.javaweb.edutest.dto.request.RootCommentRequestDTO;
import com.javaweb.edutest.dto.response.CommentResponseDTO;
import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.mapper.CommentMapper;
import com.javaweb.edutest.model.*;
import com.javaweb.edutest.repository.*;
import com.javaweb.edutest.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final RootCommentRepository rootCommentRepository;
    private final ReplyCommentRepository replyCommentRepository;
    private final UserRepository userRepository;
    private final TestRepository testRepository;

    @Override
    public CommentResponseDTO getComment(long commentId) {
        var commentResponseDTO = commentMapper.toCommentResponseDTO(findCommentById(commentId));
        addReplyCommentCountToRootCommentResponseDTO(commentResponseDTO);
        return commentResponseDTO;
    }

    @Override
    public List<CommentResponseDTO> getRootCommentsInTest(long testId) {
        List<RootComment> commentCurrent = rootCommentRepository.findByTest_IdOrderByIdAsc(testId);
        List<CommentResponseDTO> results = commentMapper.toRootCommentResponseDTOs(commentCurrent);
        addReplyCommentCountToRootCommentResponseDTOs(results);
        return results;
    }

    @Override
    public List<CommentResponseDTO> getReplyCommentsOfCurrentComment(long currentCommentId) {
        var replyComments = replyCommentRepository.findByParentComment_Id(currentCommentId);
        var replyCommentDTOs = commentMapper.toReplyCommentResponseDTOs(replyComments);
        addReplyCommentCountToRootCommentResponseDTOs(replyCommentDTOs);
        return replyCommentDTOs;
    }

    @Override
    public long addRootComment(RootCommentRequestDTO rootCommentRequestDTO) {
        RootComment newComment = commentMapper.toComment(rootCommentRequestDTO);
        newComment.setAuthor(findUser(1L));
        newComment.setTest(findTestById(rootCommentRequestDTO.getTestId()));
        rootCommentRepository.save(newComment);
        return newComment.getId();
    }

    @Override
    public long addReplyComment(ReplyCommentRequestDTO replyCommentRequestDTO){
        ReplyComment newComment = commentMapper.toComment(replyCommentRequestDTO);
        newComment.setParentComment(findCommentById(replyCommentRequestDTO.getParentCommentId()));
        replyCommentRepository.save(newComment);
        return newComment.getId();
    }

    @Override
    public void updateComment(long commentId, CommentRequestDTO commentRequestDTO) {
        Comment currentComment = findCommentById(commentId);
        commentMapper.updateComment(currentComment, commentRequestDTO);
        commentRepository.save(currentComment);
    }

    @Override
    public void deleteComment(long commentId) {
        commentRepository.deleteById(commentId);
    }

    private void addReplyCommentCountToRootCommentResponseDTOs(List<CommentResponseDTO> commentResponseDTOs) {
        commentResponseDTOs.forEach(this::addReplyCommentCountToRootCommentResponseDTO);
    }

    private void addReplyCommentCountToRootCommentResponseDTO(CommentResponseDTO commentResponseDTO) {
        commentResponseDTO.setSubCommentCount(replyCommentRepository.countByParentComment_Id(commentResponseDTO.getId()));
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

    private User findUser(long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("user not found with id : " +userId)
        );
    }
}
