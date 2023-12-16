package com.task.likes.dao;

import com.task.likes.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikeRepository extends JpaRepository<Like, Long> {
//get int likes by post id
    Integer countLikesByPostId(Long id);

    Like findByUser_IdAndPost_Id(Long userId, Long postId);

    void deleteLikeById(Long id);

}
