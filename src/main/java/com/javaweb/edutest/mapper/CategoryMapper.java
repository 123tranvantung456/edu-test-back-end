package com.javaweb.edutest.mapper;

import com.javaweb.edutest.dto.request.CategoryRequestDTO;
import com.javaweb.edutest.dto.response.CategoryResponseDTO;
import com.javaweb.edutest.dto.response.QuestionResponseDTO;
import com.javaweb.edutest.model.Category;
import com.javaweb.edutest.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO toCategoryResponseDTO(Category category);
    List<CategoryResponseDTO> toCategoryResponseDTOs(List<Category> categoryList);
    void toCategory(@MappingTarget Category category, CategoryRequestDTO categoryRequestDTO);
    @Mapping(target = "categories", ignore = true)
    QuestionResponseDTO questionToQuestionResponseDTO(Question question);
}
