package com.task.posts.service;

import com.task.exception.ResourceNotFound;
import com.task.posts.dao.PostDao;
import com.task.posts.dto.PostDto;
import com.task.posts.dto.PostMapper;
import com.task.posts.entity.Post;
import com.task.posts.request.PostRegistrationRequest;
import com.task.users.dao.UserDao;
import com.task.users.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//Moamel

@Service
public class PostService {
    private final UserDao userDao;
    private final PostDao postDao;
    private final PostMapper mapper;

    public PostService(UserDao userDao,
                       @Qualifier("PostJpa") PostDao postDao,
                       @Qualifier("PostMapperImp") PostMapper mapper) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.mapper = mapper;
    }

    public List<PostDto> getALlPosts(){
        List<Post> posts = postDao.getAllPosts();
        return posts
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


    public PostDto getPostById(Long id){
        Post post = postDao.findById(id).orElseThrow(
                ()->new ResourceNotFound(
                        "post with id " + id + "not found "
                ));
        return mapper.toDto(post);
    }

    public List<PostDto> getPostByUserID(Long id){
        List<Post> posts = postDao.getPostByUserID(id);
        return posts
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void createPost(PostRegistrationRequest request,Long id){
        User user = userDao.findById(id).orElseThrow(
                ()->new ResourceNotFound(
                        "user with id " + id + "not found "
                ));
        Post post = new Post(
                request.title(),
                request.content()
        );
        post.setUser(user);
        postDao.createPost(post);
    }



    public void updatePost(PostRegistrationRequest request,Long id){
        Post post = postDao.findById(id).orElseThrow(
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
        if(postDao.findById(id).isEmpty())
            throw new ResourceNotFound("Post not found");
        postDao.deletePost(id);
    }


}
