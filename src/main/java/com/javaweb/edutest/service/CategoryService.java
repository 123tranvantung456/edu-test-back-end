package com.javaweb.edutest.service;

import com.javaweb.edutest.dto.request.UserRequestDTO;
import com.javaweb.edutest.dto.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> getCategories();
    CategoryResponseDTO getCategory(long categoryId);
    long addCategory(UserRequestDTO user);
    void updateCategory(UserRequestDTO user);
    void deleteCategory(List<Long> categoryId);
}
