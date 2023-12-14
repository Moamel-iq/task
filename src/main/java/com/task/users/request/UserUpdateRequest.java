package com.task.users.request;

public record UserUpdateRequest (
        String name,
        String email,
        String image,
        String phone

){
}
