package com.task.likes.dao;

import com.task.likes.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
//get int likes by post id
    int countByPostId(Long id);
}
