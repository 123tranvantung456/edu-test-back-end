package com.javaweb.edutest.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RootCommentRequestDTO extends CommentRequestDTO{
    private long testId;
}