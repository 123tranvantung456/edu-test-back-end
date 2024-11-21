package com.javaweb.edutest.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyCommentRequestDTO extends CommentRequestDTO{
    private long parentCommentId;
}
