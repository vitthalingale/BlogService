package com.blog.service;

import com.blog.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    String createCategory(CategoryDto categoryDto);
    String updateCategory(CategoryDto categoryDto,Long id);

    List<CategoryDto> getAllCategory();

    CategoryDto getCategory(Long categoryId);
}
