package com.task.users.service;

import com.task.users.dao.UserDao;
import com.task.users.dto.UserDto;
import com.task.users.dto.UserMapper;
import com.task.users.entity.User;
import com.task.users.request.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
////Moamel
@Service
public class userService {
    private final UserDao userDao;
    private final UserMapper userMapper;


    public userService(@Qualifier("userJpa") UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

//    public List<UserDto> getAllUsers(){
//        return userDao.getAllUser()
//                .stream()
//                .map(userMapper::toDto)
//                .collect(Collectors.toList());
//    }

    public void addUser(UserRegistrationRequest request){
       String email = request.email();
       String phone = request.phone();
       if ((userDao.existsUserWithEmail(email)) | userDao.existsUserWithPhone(phone)){
           throw new IllegalStateException("email or phone already exists");
       }
        User user = new User(
                request.name(),
                request.email(),
                request.phone(),
                request.image()
        );

        userDao.createUser(user);
    }




}
