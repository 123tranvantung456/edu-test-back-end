package com.javaweb.edutest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javaweb.edutest.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class QuestionResponseDTO {
    private long id;
    private String content;
    private String answer;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Set<CategoryResponseDTO> categories;
}
