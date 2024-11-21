package com.javaweb.edutest.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChoiceRequestDTO {
    private String content;
    private String image;
    private boolean isCorrect;
}
