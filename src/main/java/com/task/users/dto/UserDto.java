package com.task.users.dto;

import lombok.Data;

////Moamel
@Data
public record UserDto(
        Long id,
        String name,
        String email,
        String image,
        String phone
) {

}
