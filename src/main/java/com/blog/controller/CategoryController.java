package com.blog.controller;

import com.blog.dto.CategoryDto;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public String createCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @PostMapping("/update")
    public String updateCategory(@RequestBody CategoryDto categoryDto,@RequestParam Long id){
        return categoryService.updateCategory(categoryDto,id);
    }

    @GetMapping("/all")
    public List<CategoryDto> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/singleCategory")
    public CategoryDto getAllCategory(@RequestParam Long categoryId){
        return  categoryService.getCategory(categoryId);
    }
}