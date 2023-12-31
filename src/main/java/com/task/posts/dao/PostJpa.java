package com.task.posts.dao;

import com.task.posts.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//Moamel
@Repository("PostJpa")
public class PostJpa implements PostDao {
    private final PostRepository postRepository;

    public PostJpa(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {

        return postRepository.getAll();
    }
    @Override
    public void updatePost(Post post) {

        postRepository.save(post);
    }
    @Override
    public Optional<Post> findById(Long id) {

        return postRepository.findById(id);
    }
    @Override
    public void createPost(Post post) {

        postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);

    }

    @Override
    public List<Post> getPostByUserID(Long id) {

        return postRepository.getPostByUserId(id);
    }
}