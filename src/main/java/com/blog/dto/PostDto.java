package com.blog.dto;

import com.blog.model.Category;
import com.blog.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PostDto {

    private String title;
    private String content;
    private UserDto user;
    private CategoryDto category;
    private String imageName;
    private Date createdDate;

}
