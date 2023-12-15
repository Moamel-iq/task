package com.task.posts.dto;
//Moamel


public record PostDto(
        String createdAt,
        Long userID,
        Long postId,
        String title,
        String content,
        Integer likes
) {


}




