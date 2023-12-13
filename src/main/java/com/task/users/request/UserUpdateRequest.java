package com.task.users.request;

public record UserUpdateRequest (
        String name,
        String email,
        String phone,
        String image

){
}
