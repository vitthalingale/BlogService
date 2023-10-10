package com.blog.serviceimpl;

import com.blog.dto.CategoryDto;
import com.blog.exception.ResourceNotFoundException;
import com.blog.model.Category;
import com.blog.repo.CategoryRepo;
import com.blog.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired

    private CategoryRepo categoryRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public String createCategory(CategoryDto categoryDto) {
       /* Category category= new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        category.setCategoryTitle(categoryDto.getCategoryTitle());
         categoryRepo.save(category);*/
        Category category = modelMapper.map(categoryDto, Category.class);
        Category addCategory = categoryRepo.save(category);
        modelMapper.map(addCategory,categoryDto);
        return "successfully added category";
    }

    @Override
    public String updateCategory(CategoryDto categoryDto, Long categoryId) {
         Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
           category.setCategoryTitle(categoryDto.getCategoryTitle());
           category.setCategoryDescription(categoryDto.getCategoryDescription());
          Category save = categoryRepo.save(category);
          modelMapper.map(save,categoryDto);
          return "Successfully updated category";

    }


    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDto> categoryDtos =new ArrayList<>();
        for (Category c: categories) {
            categoryDtos.add(modelMapper.map(c,CategoryDto.class));
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category","categoryid", categoryId));
        return modelMapper.map(category, CategoryDto.class);
    }

}
