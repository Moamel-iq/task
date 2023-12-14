package com.task.comments.dto;

//Ridha
public record CommentDto(
        Long userId,
        Long postId,
        Long commentId,
        String content

) {
}
