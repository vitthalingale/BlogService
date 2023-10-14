package com.blog.controller;

import com.blog.dto.CategoryDto;
import com.blog.service.CategoryService;
import jakarta.validation.Valid;
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
    public String createCategory(@Valid  @RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @PostMapping("/update")
    public String updateCategory(@Valid @RequestBody CategoryDto categoryDto,@RequestParam Long id){
        return categoryService.updateCategory(categoryDto,id);
    }

    @GetMapping("/all")
    public List<CategoryDto> getAllCategory(@RequestParam (required = false,defaultValue = "1") int page,@RequestParam(required = false,defaultValue = "10") int size){
        return categoryService.getAllCategory(page,size);
    }
    @GetMapping("/singleCategory")
    public CategoryDto getAllCategory(@RequestParam Long categoryId){
        return  categoryService.getCategory(categoryId);
    }
}
