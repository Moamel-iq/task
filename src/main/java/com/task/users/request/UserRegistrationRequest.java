package com.task.users.request;

public record UserRegistrationRequest(
        String name,
        String email,
        String image,
        String phone
) {
}
