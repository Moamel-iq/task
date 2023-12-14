package com.task.likes.dao;

import com.task.likes.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
//get int likes by post id
    Integer countLikesByPostId(Long id);
//get like by user and post
    void findLikeByPostIdAndUserId(Long userId, Long postId);

}
