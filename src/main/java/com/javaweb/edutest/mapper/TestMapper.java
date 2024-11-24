package com.javaweb.edutest.mapper;

import com.javaweb.edutest.dto.request.TestRequestDTO;
import com.javaweb.edutest.dto.response.TestResponseDTO;
import com.javaweb.edutest.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.*;

@Mapper(componentModel = "spring")
public interface TestMapper {
    List<TestResponseDTO> toTestResponseDTOs(List<Test> tests);
    TestResponseDTO toTestResponseDTO(Test test);
    Test toTest(TestRequestDTO testRequestDTO);
    void updateTest(@MappingTarget Test test, TestRequestDTO testRequestDTO);
}
