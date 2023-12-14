package com.task.comments.services;


import com.task.comments.dao.CommentDao;
import com.task.comments.dto.CommentDto;
import com.task.comments.dto.CommentMapper;
import com.task.comments.entity.Comment;
import com.task.comments.request.CommentRegistrationRequest;
import com.task.exception.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Ridha
@Service
public class CommentService {
    private final CommentDao commentDao;
    private final CommentMapper commentMapper;


    public CommentService(CommentDao commentDao, CommentMapper commentMapper) {
        this.commentDao = commentDao;
        this.commentMapper = commentMapper;
    }

    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentDao.getAllComments();
        return comments
                .stream()
                .map(commentMapper)
                .collect(Collectors.toList());
    }

    public CommentDto getCommentById(Long id) {
        return commentDao.getCommentById(id)
                .map(commentMapper)
                .orElseThrow(
                        () -> new ResourceNotFound("Comment not found")
                );
    }

    public List<CommentDto> getCommentByPostId(Long id) {
        List<Comment> comments = commentDao.getCommentByPostId(id);
        return comments
                .stream()
                .map(commentMapper)
                .collect(Collectors.toList());
    }

    public void createComment(CommentRegistrationRequest registrationRequest) {
        Comment comment = new Comment(
                registrationRequest.content()

        );

        commentDao.createComment(comment);
    }

    public void updateComment(CommentRegistrationRequest registrationRequest, Long id) {
        boolean change = false;
        Comment comment = commentDao.getCommentById(id).orElseThrow(
                () -> new ResourceNotFound("Comment not found")
        );
        if (registrationRequest.content() != null && !registrationRequest.content().equals(comment.getContent())) {
            comment.setContent(registrationRequest.content());
            change = true;

        }
        if (change) {
            commentDao.updateComment(comment, id);
        }
    }

    public void deleteComment(Long id) {
        if (!commentDao.getCommentById(id).isPresent())
            throw new ResourceNotFound("Comment not found");
        commentDao.deleteComment(id);
    }

}
