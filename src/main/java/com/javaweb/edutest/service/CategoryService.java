package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.CategoryRequestDTO;
import com.javaweb.edutest.dto.request.UserRequestDTO;
import com.javaweb.edutest.dto.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> getCategories();
    CategoryResponseDTO getCategory(long categoryId);
    long addCategory(CategoryRequestDTO user);
    void updateCategory(long categoryId, CategoryRequestDTO user);
    void deleteCategory(long categoryId);
}
