package com.task.posts.dto;

//Moamel

import com.task.comments.dto.CommentDto;
import com.task.comments.entity.Comment;

import java.util.List;

public record PostDto(
        String title,
        String content,
        List<CommentDto> commentDto

){
}
