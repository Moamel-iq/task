package com.task.users.dto;

import com.task.users.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDto toDto(User user){
        return  new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getImage(),
                user.getPhone()
        );
    }
}
