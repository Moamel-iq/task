package com.task.users.controller;

import com.task.users.dto.UserDto;
import com.task.users.request.UserRegistrationRequest;
import com.task.users.request.UserUpdateRequest;
import com.task.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Moamel
@RestController
@RequestMapping(path = "api/v1/users")
public class userController {
    private final UserService userService;

    @Autowired
    public userController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<UserDto> getAllUser(){

        return userService.getAllUsers();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addUser(
            @RequestBody UserRegistrationRequest request){
            userService.addUser(request);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateUser(
            @RequestBody UserUpdateRequest request,
            @PathVariable Long id){
        userService.updateUser(request,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteUser(
            @PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public UserDto getUserById(
            @PathVariable(name = "id") Long id){

        return userService.getUserById(id);
    }



}
