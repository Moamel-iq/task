package com.task.likes.dao;

import com.task.likes.entity.Like;
import com.task.posts.entity.Post;
import com.task.users.entity.User;

public interface LikeDao {

    Integer getAllLikesByPostId(Long id);
    void createLike(Like like);
    void deleteLike(Long id);
    Like findByUserAndPost(Long userId, Long postId);

}
