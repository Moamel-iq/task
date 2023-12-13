package com.task.posts.service;

import com.task.exception.ResourceNotFound;
import com.task.posts.dao.PostDao;
import com.task.posts.dto.PostDto;
import com.task.posts.dto.PostMapper;
import com.task.posts.entity.Post;
import com.task.posts.request.PostRegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostDao postDao;
    private final PostMapper toDto;

    public PostService(PostDao postDao, PostMapper postMapper) {
        this.postDao = postDao;
        this.toDto = postMapper;
    }

    public List<PostDto> getALlPosts(){
        List<Post> posts = postDao.getAllPosts();
        return posts
                .stream()
                .map(toDto)
                .collect(Collectors.toList());
    }

    public PostDto getPostById(Long id) {
        return postDao.getPostById(id).
                map(toDto)
                .orElseThrow(
                        () -> new ResourceNotFound("Post not Found")
                );
    }

    public List<PostDto> getPostByUserID(Long id){
        List<Post> posts = postDao.getPostByUserID(id);
        return posts
                .stream()
                .map(toDto)
                .collect(Collectors.toList());
    }


    public void createPost(PostRegistrationRequest request) {
        Post post = new Post(
                request.title(),
                request.content()
        );
        postDao.createPost(post);

    }

    public void updatePost(PostRegistrationRequest request,Long id){
        Post post = postDao.getPostById(id).orElseThrow(
                ()->new ResourceNotFound(
                        "post with id " + id + "not found "
                ));
        boolean changes = false;
        if (request.title() != null && !request.title().equals(post.getTitle())) {
            post.setTitle(request.title());
            changes = true;
        }
        if (request.content() != null && !request.content().equals(post.getContent())) {
            post.setContent(request.content());
            changes = true;
        }
        if (changes) {
            postDao.updatePost(post, id);
        }
    }

    public void deletePost(Long id){
        postDao.deletePost(id);
    }


}
