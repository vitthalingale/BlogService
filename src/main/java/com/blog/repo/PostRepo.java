package com.blog.repo;

import com.blog.dto.PostDto;
import com.blog.dto.UserDto;
import com.blog.model.Category;
import com.blog.model.Post;
import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {


    List<Post> findByCategory(Category category);

    List<Post> findByUser(User user);
}
