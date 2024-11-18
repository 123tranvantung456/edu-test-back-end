package com.javaweb.edutest.service.impl;

import com.javaweb.edutest.dto.request.CategoryRequestDTO;
import com.javaweb.edutest.dto.response.CategoryResponseDTO;
import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.mapper.CategoryMapper;
import com.javaweb.edutest.model.Category;
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
        return categoryMapper.toCategoryResponseDTO(getCategoryById(categoryId));
    }

    @Override
    public long addCategory(CategoryRequestDTO user) {
        Category newCategory = categoryMapper.toCategory(user);
        categoryRepository.save(newCategory);
        return newCategory.getId();
    }

    @Override
    public void updateCategory(long categoryId, CategoryRequestDTO userRequestDTO) {
        Category categoryCurrent = getCategoryById(categoryId);
        categoryMapper.toCategory(categoryCurrent, userRequestDTO);
        categoryRepository.save(categoryCurrent);
    }

    @Override
    public void deleteCategory(long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    private Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("category not found")
        );
    }
}
