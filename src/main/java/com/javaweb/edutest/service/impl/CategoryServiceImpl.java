package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.UserRequestDTO;
import com.javaweb.edutest.dto.response.CategoryResponseDTO;
import com.javaweb.edutest.mapper.CategoryMapper;
import com.javaweb.edutest.repository.CategoryRepository;
import com.javaweb.edutest.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDTO> getCategories() {
        return categoryMapper.toCategoryResponseDTOs(categoryRepository.findAll());
    }

    @Override
    public CategoryResponseDTO getCategory(long categoryId) {
        return null;
    }

    @Override
    public long addCategory(UserRequestDTO user) {
        return 0;
    }

    @Override
    public void updateCategory(UserRequestDTO user) {

    }

    @Override
    public void deleteCategory(List<Long> categoryId) {

    }

    private
}
