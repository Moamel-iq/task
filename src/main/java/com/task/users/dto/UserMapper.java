package com.task.users.dto;

import com.task.users.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
//Ridha
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper MAPPER= Mappers.getMapper(UserMapper.class);

    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}
