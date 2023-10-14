package com.blog.serviceimpl;

import com.blog.dto.PostDto;
import com.blog.dto.UserDto;
import com.blog.exception.ResourceNotFoundException;
import com.blog.model.Category;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.repo.CategoryRepo;
import com.blog.repo.PostRepo;
import com.blog.repo.UserRepo;
import com.blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public String createPost(PostDto postDto,Long userId,Long categoryId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));

        Post post = modelMapper.map(postDto, Post.class);
        post.setImageName("photo.png");
        post.setUser(user);
        post.setCategory(category);
        post.setCreatedDate(postDto.getCreatedDate());
        Post addPost = postRepo.save(post);
        modelMapper.map(addPost,postDto);
        return "successfully added post";
    }

    @Override
    public String updatePost(PostDto postDto, Long id) {
        Post existingpost = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "postId", id));
       existingpost.setTitle(postDto.getTitle());
       existingpost.setContent(postDto.getContent());
       existingpost.setCreatedDate(postDto.getCreatedDate());
        Post save = postRepo.save(existingpost);
        modelMapper.map(save,postDto);
        return "successfully update";
    }

    @Override
    public List<PostDto> getAllPost(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page - 1, size);
            Page<Post> all = postRepo.findAll(pageRequest);
            List<PostDto> postDtos = new ArrayList<>();
            for (Post p : all) {
                postDtos.add(modelMapper.map(p, PostDto.class));
            }
            return postDtos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "postId", id));
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("catefory","categroyId",categoryId));
        List<Post> posts = postRepo.findByCategory(category);
        List<PostDto> postDto = posts.stream().map((element) -> modelMapper.map(element, PostDto.class)).collect(Collectors.toList());
        return postDto;
    }

    @Override
    public List<PostDto> getPostByUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user","userId",userId));
        List<Post> posts = postRepo.findByUser(user);
        List<PostDto> postDto = posts.stream().map((element) -> modelMapper.map(element, PostDto.class)).collect(Collectors.toList());
        return postDto;
    }

    @Override
    public String  deletePost(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "postId", id));
        postRepo.deleteById(post.getId());
     return "successfully deleted";
    }
}
