package com.task.likes.service;

import com.task.exception.ResourceNotFound;
import com.task.likes.dao.LikeDao;
import com.task.likes.dto.LikeMapper;
import com.task.likes.entity.Like;
import com.task.posts.dao.PostDao;
import com.task.posts.entity.Post;
import com.task.users.dao.UserDao;
import com.task.users.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private final LikeDao likeDao;


    private final UserDao userDao;
    private final PostDao postDao;
    public LikeService(LikeDao likeDao, UserDao userDao, PostDao postDao) {
        this.likeDao = likeDao;
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
        Like like = likeDao.findByUserAndPost(userId, postId);
        if (like != null) {
            likeDao.deleteLike(like.getId());
            return;
        }
        Like newLike = new Like();
        newLike.setUser(user);
        newLike.setPost(post);
        likeDao.createLike(newLike);

    }

    public void deleteLike(Long userId, Long postId) {
        Like like = likeDao.findByUserAndPost(userId, postId);
        if (like == null) {
            throw new ResourceNotFound("Like not found with userId: " + userId + " and postId: " + postId);
        }
        likeDao.deleteLike(like.getId());
    }
}
