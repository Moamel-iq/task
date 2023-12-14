package com.task.likes.controller;

import com.task.likes.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/count")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Integer countLikesByPostId(Long id){
        return likeService.countLikesByPostId(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addLike(Long userId,Long postId){
         likeService.likePost(userId,postId);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(Long userId,Long postId){
        likeService.deleteLike(userId,postId);
    }

}
