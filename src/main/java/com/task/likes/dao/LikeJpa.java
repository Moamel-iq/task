package com.task.likes.dao;

import com.task.likes.entity.Like;
import com.task.posts.entity.Post;
import com.task.users.entity.User;
import org.springframework.stereotype.Repository;

@Repository("Jpa")
public class LikeJpa implements LikeDao{
    private final LikeRepository likeRepository;

    public LikeJpa(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }


    @Override
    public Integer getAllLikesByPostId(Long id) {
        return likeRepository.countLikesByPostId(id);
    }

    @Override
    public void createLike(Like like) {
        likeRepository.save(like);
    }

    @Override
    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }

    @Override
    public Like findByUserAndPost(Long userId, Long postId) {
        likeRepository.findLikeByPostIdAndUserId(userId, postId);
        return null;
    }


}
