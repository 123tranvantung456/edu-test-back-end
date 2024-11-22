package com.javaweb.edutest.mapper;

import com.javaweb.edutest.dto.request.CommentRequestDTO;
import com.javaweb.edutest.dto.request.ReplyCommentRequestDTO;
import com.javaweb.edutest.dto.request.RootCommentRequestDTO;
import com.javaweb.edutest.dto.response.CommentResponseDTO;
import com.javaweb.edutest.model.Comment;
import com.javaweb.edutest.model.ReplyComment;
import com.javaweb.edutest.model.RootComment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.*;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    RootComment toComment(RootCommentRequestDTO rootCommentRequestDTO);
    ReplyComment toComment(ReplyCommentRequestDTO replyCommentRequestDTO);
    Comment toComment(CommentRequestDTO commentRequestDTO);
    CommentResponseDTO toCommentResponseDTO(Comment comment);
    List<CommentResponseDTO> toRootCommentResponseDTOs(List<RootComment> comments);
    List<CommentResponseDTO> toReplyCommentResponseDTOs(List<ReplyComment> comments);
    void updateComment(@MappingTarget Comment comment, CommentRequestDTO commentRequestDTO);
}
