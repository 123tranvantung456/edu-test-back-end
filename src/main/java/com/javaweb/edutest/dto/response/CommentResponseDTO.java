package com.javaweb.edutest.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentResponseDTO {
    private long id;
    private String content;
    private int subCommentCount;
}