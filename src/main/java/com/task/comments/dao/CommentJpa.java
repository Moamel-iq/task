package com.task.comments.dao;

import com.task.comments.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//Ridha
@Repository("CommentJpa")
public class CommentJpa implements CommentDao{
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getComment(Long id) {

        return commentRepository.findById(id);
    }

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void updateComment(Comment comment, Long id) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);

    }

    @Override
    public List<Comment> getCommentsByPostId(Long id) {
        return null;
    }
}
