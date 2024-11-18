package com.javaweb.edutest.controller;

import com.javaweb.edutest.dto.request.CategoryRequestDTO;
import com.javaweb.edutest.dto.response.CategoryResponseDTO;
import com.javaweb.edutest.dto.response.ResponseData;
import com.javaweb.edutest.exception.ResourceNotFoundException;
import com.javaweb.edutest.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public ResponseData<List<CategoryResponseDTO>> getCategories() {
        try {
            return new  ResponseData<>(categoryService.getCategories(), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        }catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping("/{categoryId}")
    public ResponseData<CategoryResponseDTO> getCategory(@PathVariable int categoryId) {
        try {
            return new ResponseData<>(categoryService.getCategory(categoryId), HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        }
        catch (ResourceNotFoundException e){
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
        catch (Exception e){
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PostMapping
    public ResponseData<Long> addCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        try {
            return new ResponseData<>(categoryService.addCategory(categoryRequestDTO), HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @PutMapping("/{categoryId}")
    public ResponseData<?> updateCategory(@PathVariable long categoryId
            ,@RequestBody CategoryRequestDTO categoryRequestDTO) {
        try {
            categoryService.updateCategory(categoryId, categoryRequestDTO);
            return new ResponseData<>(HttpStatus.CREATED.value(), HttpStatus.ACCEPTED.getReasonPhrase());
        }
        catch (ResourceNotFoundException e){
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
        catch (Exception e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseData<?> deleteCategory(@PathVariable long categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
            return new ResponseData<>(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase());
        } catch (Exception e){
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
}
