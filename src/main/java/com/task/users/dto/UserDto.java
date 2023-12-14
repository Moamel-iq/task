package com.task.users.dto;

import lombok.Data;

////Moamel
@Data
public class UserDto{
        Long id;
        String name;
        String email;
        String image;
        String phone;

    public UserDto() {
    }

    public UserDto(Long id, String name, String email, String image, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
        this.phone = phone;
    }

}
