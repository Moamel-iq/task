package com.task.comments.dao;

import com.task.comments.entity.Comment;

import java.util.List;
import java.util.Optional;
//Ridha
public class CommentJpa implements CommentDao{
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public Optional<Comment> getComment(Long id) {
        return Optional.empty();
    }

    @Override
    public void createComment(Comment comment) {

    }

    @Override
    public void updateComment(Comment comment, Long id) {

    }

    @Override
    public void deleteComment(Long id) {

    }
}
