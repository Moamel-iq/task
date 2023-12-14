package com.task.likes.service;

import com.task.exception.ResourceNotFound;
import com.task.likes.dao.LikeDao;
import com.task.likes.dto.LikeMapper;
import com.task.likes.entity.Like;
import com.task.posts.dao.PostDao;
import com.task.posts.entity.Post;
import com.task.users.dao.UserDao;
import com.task.users.entity.User;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private final LikeDao likeDao;
    private final LikeMapper likeMapper;

    private final UserDao userDao;
    private final PostDao postDao;
    public LikeService(LikeDao likeDao, LikeMapper likeMapper, UserDao userDao, PostDao postDao) {
        this.likeDao = likeDao;
        this.likeMapper = likeMapper;
        this.userDao = userDao;
        this.postDao = postDao;
    }

    public Integer countLikesByPostId(Long id){
        return likeDao.getAllLikesByPostId(id);
    }

    public void likePost(Long userId, Long postId) {
        User user = userDao.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFound("User not found with id: " + userId));

        Post post = postDao.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFound("Post not found with id: " + postId));
        // if user already liked
        Like like = new Like(true, user, post);
        likeDao.createLike(like);
    }

    public void deleteLike(Long userId, Long postId) {
        User user = userDao.findById(userId)
                .orElseThrow(
                        ()->new ResourceNotFound("user not found")
                );

        Post post = postDao.findById(postId)
                .orElseThrow(
                        ()-> new ResourceNotFound("Post not found")
                );
        Like existingLike = likeDao.findByUserAndPost(user.getId(), post.getId());
        if (existingLike != null) {
            likeDao.deleteLike(existingLike.getId());
        }


    }
}
