package com.task.likes.dto;

public record LikeDto (
        Long postId,
        Long userId,
        Integer likes

){
}
