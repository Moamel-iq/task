package com.task.likes.controller;

import com.task.likes.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/like")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {

        this.likeService = likeService;
    }

    @GetMapping("/count")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Integer countLikesByPostId(
            @RequestParam(name = "postId") Long postId){
        return likeService.countLikesByPostId(postId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addLike(
            @RequestParam(name = "userId") Long userId,
            @RequestParam(name = "postId") Long postId){
         likeService.likePost(userId,postId);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(
            @RequestParam(name = "userId") Long userId,
            @RequestParam(name = "postId") Long postId)
    {
        likeService.deleteLike(userId,postId);
    }
}
