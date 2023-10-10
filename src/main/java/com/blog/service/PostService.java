package com.blog.service;

import com.blog.dto.PostDto;
import com.blog.model.Post;

import java.util.List;

public interface PostService {

    String createPost(PostDto postDto,Long userId,Long categoryId);

    String updatePost(PostDto postDto,Long id);

    List<PostDto> getAllPost();

    PostDto getPostById(Long id);



}
