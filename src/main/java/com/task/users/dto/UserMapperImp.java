package com.task.users.dto;

import com.task.users.entity.User;
import org.springframework.stereotype.Repository;

@Repository("UserMapperImp")
public class UserMapperImp implements UserMapper{
    @Override
    public UserDto toDto(User user) {
        if (user == null ){
            return null;
        }
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getImage()
        );
    }
    @Override
    public User toUser(UserDto userDto) {

        if (userDto == null){
            return null;
        }
        return new User(
                userDto.getName(),
                userDto.getEmail(),
                userDto.getImage(),
                userDto.getPhone()
        );
    }
}
