package com.task.posts.controller;

import com.task.posts.dto.PostDto;

import com.task.posts.request.PostRegistrationRequest;
import com.task.posts.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Moamel
@RestController
@RequestMapping(path = "api/v1/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<PostDto> getAllPosts(){

        return postService.getALlPosts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public PostDto getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<PostDto> getPostByUserId(@PathVariable Long id){
        return postService.getPostByUserID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addPost(@RequestBody PostRegistrationRequest request){
        postService.createPost(request);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updatePost(
            @RequestBody PostRegistrationRequest request,
            @PathVariable Long id ){
        postService.updatePost(request,id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

}
