package com.javaweb.edutest.mapper;

import com.javaweb.edutest.dto.request.CommentRequestDTO;
import com.javaweb.edutest.dto.response.CommentResponseDTO;
import com.javaweb.edutest.model.Comment;
import com.javaweb.edutest.model.RootComment;
import org.mapstruct.Mapper;

import java.util.*;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment toComment(CommentRequestDTO commentRequestDTO);
    CommentResponseDTO toCommentResponseDTO(Comment comment);
    List<CommentResponseDTO> toCommentResponseDTOList(List<RootComment> comments);
}
