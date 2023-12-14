package com.task.comments.dao;

import com.task.comments.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//ridha
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> getAllByPostId(Long postId);
    @Query("SELECT c FROM Comment c order by c.createdAt")//order by likes
    List<Comment>getAll();




}
