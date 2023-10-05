package com.blog.serviceimpl;

import com.blog.dto.UserDto;
import com.blog.model.User;
import com.blog.repo.UserRepo;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public String createUser(User user) {
        userRepo.save(user);
        return "successfully created user";
    }

    @Override
    public String updateUser(UserDto userDto, Long id) {
        Optional<User> existingUserOptional = userRepo.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setName(userDto.getName());
            existingUser.setEmail(userDto.getEmail());
            existingUser.setAbout(userDto.getAbout());
            existingUser.setMobileNo(userDto.getMobileNo());
            userRepo.save(existingUser);
            return "Successfully updated";
        } else {
            return "User not found";
        }
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepo.findById(id).get();
    }


}
