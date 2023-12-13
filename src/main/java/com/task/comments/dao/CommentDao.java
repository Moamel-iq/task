package com.task.comments.dao;

//Ridha

import com.task.comments.entity.Comment;

import java.util.List;
import java.util.Optional;
//Ridha
public interface CommentDao {

    List<Comment> getAllComments();

    Optional<Comment>getComment(Long id);

    void createComment(Comment comment);

    void updateComment(Comment comment, Long id);

    void deleteComment(Long id);



}
