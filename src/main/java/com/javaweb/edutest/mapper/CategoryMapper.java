package com.javaweb.edutest.mapper;

import com.javaweb.edutest.dto.request.CategoryRequestDTO;
import com.javaweb.edutest.dto.response.CategoryResponseDTO;
import com.javaweb.edutest.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO toCategoryResponseDTO(Category category);
    List<CategoryResponseDTO> toCategoryResponseDTOs(List<Category> categoryList);
}
