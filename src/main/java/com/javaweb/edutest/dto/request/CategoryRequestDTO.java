package com.javaweb.edutest.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoryRequestDTO implements Serializable {
    private String name;
}
