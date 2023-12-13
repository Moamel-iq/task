package com.task.posts.dao;

import com.task.posts.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//Moamel
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT p FROM Post p order by p.createdAt")
    List<Post> getAll();

    List<Post> getPostByUserId(Long id);

}
