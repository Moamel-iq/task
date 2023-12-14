package com.task.posts.dto;

//Moamel

import com.task.comments.dto.CommentDto;
import com.task.comments.entity.Comment;
import com.task.users.entity.User;

import java.util.List;

public record PostDto(
        Long userID,
        Long postId,
        String title,
        String content,
        Integer likes
        //image
//        List<CommentDto> comments



){
}




