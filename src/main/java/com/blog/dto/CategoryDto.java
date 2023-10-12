package com.blog.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long categoryId;

    @NotNull
    private String categoryTitle;
    @NotNull
    private String categoryDescription;

}
