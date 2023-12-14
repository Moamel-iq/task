package com.task.comments.controller;

import com.task.comments.dto.CommentDto;
import com.task.comments.request.CommentRegistrationRequest;
import com.task.comments.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Ridha

@RestController
@RequestMapping(path = "api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<CommentDto> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public CommentDto getCommentById(
            @PathVariable(name = "id") Long id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/post/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<CommentDto> getCommentByPostId(Long id) {
        return commentService.getCommentByPostId(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createComment(
                @RequestBody CommentRegistrationRequest request,
                @RequestParam(name = "userId") Long userId,
                @RequestParam(name = "postId")Long postId)
    {
        commentService.createComment(request, userId,postId);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateComment(
            @RequestBody CommentRegistrationRequest registrationRequest,
            @PathVariable Long id) {
        commentService.updateComment(registrationRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }


}
