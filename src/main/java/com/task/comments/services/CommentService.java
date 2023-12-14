package com.task.comments.services;


import com.task.comments.dao.CommentDao;
import com.task.comments.dto.CommentDto;
import com.task.comments.dto.CommentMapStruct;
import com.task.comments.dto.CommentMapper;
import com.task.comments.entity.Comment;
import com.task.comments.request.CommentRegistrationRequest;
import com.task.exception.ResourceNotFound;
import com.task.posts.dao.PostDao;
import com.task.posts.entity.Post;
import com.task.users.dao.UserDao;
import com.task.users.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Ridha
@Service
public class CommentService {
    private final CommentDao commentDao;
    private final CommentMapStruct commentMapper;
    private final PostDao postDao;
    private final UserDao userDao;

    public CommentService(@Qualifier("CommentJpa") CommentDao commentDao,
                          @Qualifier("CommentMapper") CommentMapStruct commentMapper,
                          @Qualifier("PostJpa") PostDao postDao,
                          @Qualifier("userJpa") UserDao userDao) {
        this.commentDao = commentDao;
        this.commentMapper = commentMapper;
        this.postDao = postDao;
        this.userDao = userDao;
    }

    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentDao.getAllComments();
        return comments
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }

    public CommentDto getCommentById(Long id) {
        Comment comment = commentDao.getCommentById(id).orElseThrow(
                () -> new ResourceNotFound("Comment not found")
        );
        return commentMapper.toDto(comment);
    }

    public List<CommentDto> getCommentByPostId(Long id) {
        List<Comment> comments = commentDao.getCommentByPostId(id);
        return comments
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }

    public void createComment(CommentRegistrationRequest request,
                              Long postid
            ,Long userid
    ) {
        Post post = postDao.findById(postid).orElseThrow(
                () -> new ResourceNotFound(
                        "post with id " + postid + "not found "
                ));
        User user = userDao.findById(userid).orElseThrow(
                () -> new ResourceNotFound(
                        "user with id " + userid + "not found "
                ));
        Comment comment = new Comment(
                request.content()
        );
        comment.setPost(post);
        comment.setUser(user);
        commentDao.createComment(comment);


    }

    public void updateComment(CommentRegistrationRequest registrationRequest, Long id) {
        Comment comment = commentDao.getCommentById(id).orElseThrow(
                () -> new ResourceNotFound("Comment not found")
        );
        comment.setContent(registrationRequest.content());

        commentDao.updateComment(comment, id);

    }

    public void deleteComment(Long id) {
        if (commentDao.getCommentById(id).isEmpty())
            throw new ResourceNotFound("Comment not found");
        commentDao.deleteComment(id);
    }

}
