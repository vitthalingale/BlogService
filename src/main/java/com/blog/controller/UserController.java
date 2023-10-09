package com.blog.controller;

import com.blog.common.ApiResponse;
import com.blog.dto.UserDto;
import com.blog.model.User;
import com.blog.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String  createUser( @Valid @RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PostMapping("/update")
    public String  updateUser(@Valid @RequestBody UserDto userDto, @RequestParam Long id){
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

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteUser(@RequestParam Long id){
         userService.deleteUser(id);
         return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true), HttpStatus.OK);
    }
}
