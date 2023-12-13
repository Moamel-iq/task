package com.task.users.controller;

import com.task.users.dto.UserDto;
import com.task.users.request.UserRegistrationRequest;
import com.task.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//ByMoamel
@RestController
@RequestMapping(path = "api/v1/users")
public class userController {
    private final UserService userService;

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

}