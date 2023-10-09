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
    public String createUser(UserDto userDto) {
        User user =new User();
        user.setName(userDto.getName());
        user.setMobileNo(userDto.getMobileNo());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
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
            existingUser.setPassword(userDto.getPassword());
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

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);

    }


}
