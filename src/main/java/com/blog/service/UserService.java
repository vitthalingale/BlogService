package com.blog.service;

import com.blog.dto.UserDto;
import com.blog.model.User;

import java.util.List;

public interface UserService {

   public String createUser(UserDto userDto);

   String updateUser(UserDto userDto, Long id);

   List<User> getAllUser();

   User getUser(Long id);

   void deleteUser(Long id);
}
