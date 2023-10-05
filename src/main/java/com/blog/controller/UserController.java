package com.blog.controller;

import com.blog.dto.UserDto;
import com.blog.model.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String  createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/update")
    public String  updateUser(@RequestBody UserDto userDto, @RequestParam Long id){
        return userService.updateUser(userDto,id);
    }


    @GetMapping("/all")
    public List<User> getAllUser(){
    return userService.getAllUser();
    }

    @GetMapping("/singleUser")
    public User getUser(@RequestParam Long id){
        return userService.getUser(id);
    }
}
