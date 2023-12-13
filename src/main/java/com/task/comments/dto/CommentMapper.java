package com.task.comments.dto;


import com.task.comments.entity.Comment;

//Ridha
public class CommentMapper {

    public CommentDto toDto(Comment comment){
        return new CommentDto(
                comment.getContent()

        );
    }


}
