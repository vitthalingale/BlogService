package com.blog.service;

import com.blog.dto.UserDto;
import com.blog.model.User;

import java.util.List;

public interface UserService {

   public String createUser(User user);

   String updateUser(UserDto userDto, Long id);

   List<User> getAllUser();

   User getUser(Long id);
}
