package com.task.users.service;

import com.task.users.dao.UserDao;
import com.task.users.dto.UserDto;
import com.task.users.dto.UserMapper;
import com.task.users.entity.User;
import com.task.exception.ResourceNotFound;
import com.task.users.request.RequestValidationException;
import com.task.users.request.UserRegistrationRequest;
import com.task.users.request.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

////Moamel
@Service
public class UserService {
    private final UserDao userDao;
    private final UserMapper mapper;


    public UserService(@Qualifier("userJpa") UserDao userDao, UserMapper mapper) {
        this.userDao = userDao;
        this.mapper = mapper;
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userDao.getAllUsers();
        return users.
                stream()
                .map(mapper.MAPPER::toDto
                ).collect(Collectors.toList());
    }

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

    public void updateUser(UserUpdateRequest request,Long id){
        User user =userDao.getUser(id).orElseThrow(
                ()->new ResourceNotFound(
                        "user with id " + id + "not found "
                ));
        boolean changes = false;
        if (request.name() != null && !request.name().equals(user.getName())) {
            user.setName(request.name());
            changes = true;


        }
        if (request.email() != null && !request.email().equals(user.getEmail()) &&
                !userDao.existsUserWithEmail(request.email())) {
            user.setEmail(request.email());
            changes = true;
        }

        if (!changes) {
            throw new RequestValidationException("no changes were made");

        }
        userDao.updateUser(user, id);
    }
    }


