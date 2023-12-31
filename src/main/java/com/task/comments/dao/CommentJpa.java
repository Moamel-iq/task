package com.task.comments.dao;

import com.task.comments.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Ridha
@Repository("CommentJpa")
public class CommentJpa implements CommentDao {
    private final CommentRepository commentRepo;

    public CommentJpa(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {

        return commentRepo.findById(id);
    }


    @Override
    public void createComment(Comment comment) {

        commentRepo.save(comment);
    }

    @Override
    public void updateComment(Comment comment, Long id) {

        commentRepo.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepo.deleteById(id);

    }

    @Override
    public List<Comment> getCommentByPostId(Long id) {
        return commentRepo.getCommentsByPostId(id);
    }
}
