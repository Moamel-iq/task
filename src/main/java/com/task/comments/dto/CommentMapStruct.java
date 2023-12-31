package com.task.comments.dto;

import com.task.comments.entity.Comment;
import org.mapstruct.Mapper;

//Ridha
@Mapper(componentModel = "spring")
public interface CommentMapStruct {

    CommentDto toDto(Comment comment);
    Comment toComment(CommentDto commentDto);



}
