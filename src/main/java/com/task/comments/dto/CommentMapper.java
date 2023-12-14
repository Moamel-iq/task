package com.task.comments.dto;


import com.task.comments.entity.Comment;
import org.springframework.stereotype.Repository;

//Ridha

@Repository("CommentMapper")
public class CommentMapper implements CommentMapStruct {

    @Override
    public CommentDto toDto(Comment comment) {
        if (comment == null ){
            return null;
        }
        return new CommentDto(
                comment.getUser().getId(),
                comment.getPost().getId(),
                comment.getId(),
                comment.getContent()
        );
    }

    @Override
    public Comment toComment(CommentDto commentDto) {
        return null;
    }


}
