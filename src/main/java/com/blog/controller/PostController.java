package com.blog.controller;

import com.blog.dto.PostDto;
import com.blog.model.Post;
import com.blog.repo.PostRepo;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/savePost")
    public String createPost(@RequestBody PostDto postDto,Long userId,Long categoryId){
        return postService.createPost(postDto,userId,categoryId);
    }

    @PostMapping("/update")
    public String updatePost(@RequestBody PostDto postDto, @RequestParam Long id){
        return postService.updatePost(postDto,id);
    }

    @GetMapping("/all")
    public List<PostDto> getALlPost(){
        return postService.getAllPost();
    }
    @GetMapping("/SinglePost")
    public PostDto getALlPost(@RequestParam long id){
        return postService.getPostById(id);
    }


    @GetMapping("/getPostByCategory")
    public  List<PostDto> getPostByCategory(@RequestParam Long categoryId){
        return postService.getPostByCategory(categoryId);
    }
    @GetMapping("/getPostByUser")
    public  List<PostDto> getPostByUser(@RequestParam Long userId){
        return postService.getPostByUser(userId);
    }

   @DeleteMapping("/delete")
    public String  deletePostById(@RequestParam Long id){
        return postService.deletePost(id);
   }
}
