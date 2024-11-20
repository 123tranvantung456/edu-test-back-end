package com.javaweb.edutest.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionRequestDTO {
    private String content;
    private String answer;
    private List<Long> categoryIds;
}
