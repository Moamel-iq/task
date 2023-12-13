package com.task.posts.dao;

import com.task.posts.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostDao {
    List<Post> getAllPosts();
    Optional<Post> getPost(Long id);
    void createPost(Post post);
    void updatePost(Post post , Long id);
    void deletePost(Long id);


}
