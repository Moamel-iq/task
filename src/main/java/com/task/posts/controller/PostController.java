package com.task.posts.controller;

import com.task.posts.dto.PostDto;

import com.task.posts.request.PostRegistrationRequest;
import com.task.posts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public PostDto getPostById(
            @PathVariable(name = "id") Long id){

        return postService.getPostById(id);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<PostDto> getPostByUserID(
            @PathVariable(name = "id") Long id){

        return postService.getPostByUserID(id);
    }

    @PostMapping("/add/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createPost(
            @RequestBody PostRegistrationRequest request,
            @PathVariable Long id){
        postService.createPost(request,id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updatePost(
            @RequestBody PostRegistrationRequest request,
            @PathVariable Long id ){
        postService.updatePost(request,id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deletePost(
            @RequestParam(name = "id") Long id){

        postService.deletePost(id);
    }

}
