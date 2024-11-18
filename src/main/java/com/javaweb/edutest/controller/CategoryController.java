package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.response.ResponseData;
import com.javaweb.edutest.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final Category
    @GetMapping
    public ResponseData<List<Category>> getCategories() {
        try {

        }catch (Exception e) {

        }
    }
}
