package com.task.posts.dao;

import com.task.posts.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//Moamel
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT p FROM Post p order by p.createdAt desc")
    List<Post> getAll();

    //get all post oreder by newest

    @Query("SELECT p FROM Post p where p.user.id = :id order by p.createdAt desc")
    List<Post> getPostByUserId(@Param("id") Long id);


    //get posts by user id



//    @Query("SELECT p FROM Post p order by p.likes.size desc")
//    List<Post> getLikedPosts();

}
