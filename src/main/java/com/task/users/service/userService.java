package com.task.users.service;

import com.task.users.dao.UserDao;
import com.task.users.dto.UserDto;
import com.task.users.dto.UserMapper;
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

    public List<UserDto> getAllUsers(){
        return userDao.getAllUser()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }





}
