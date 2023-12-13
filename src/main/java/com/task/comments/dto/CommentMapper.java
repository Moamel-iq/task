package com.task.comments.dto;


import com.task.comments.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.function.Function;

//Ridha

@Service
public class CommentMapper implements Function<Comment, CommentDto> {

    @Override
    public CommentDto apply(Comment comment) {
        return new CommentDto(
                comment.getContent());
    }




}
