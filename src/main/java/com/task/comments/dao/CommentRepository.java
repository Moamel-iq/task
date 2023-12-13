package com.task.comments.dao;

import com.task.comments.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//ridha
public interface CommentRepository extends JpaRepository<Comment,Long> {


    List<Comment> getAllByPostId(Long postId);

}
