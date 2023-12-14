package com.task.users.dto;
import com.task.users.entity.User;
import org.mapstruct.Mapper;
//Ridha

@Mapper
public interface UserMapper {
    UserDto toDto(User user);
    User toUser(UserDto userDto);
}
