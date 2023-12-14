package com.task.posts.dto;

import com.task.comments.dto.CommentDto;
import com.task.comments.dto.CommentMapper;
import com.task.posts.entity.Post;
import com.task.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("PostMapperImp")
public class PostMapperImp implements PostMapper{

    @Override
    public PostDto toDto(Post post) {
        if (post == null) {
            return null;
        }
        return new PostDto(
                post.getUser().getId(),
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getLikes()
        );
    }

//    private final CommentMapper commentMapper;
//
//    @Autowired
//    public PostMapperImp(CommentMapper commentMapper) {
//        this.commentMapper = commentMapper;
//    }
//
//    @Override
//    public PostDto toDto(Post post) {
//        if (post == null) {
//            return null;
//        }
//
//        List<CommentDto> commentDto = post.getComments()
//                .stream()
//                .map(commentMapper::toDto)  // Use CommentMapper to convert Comment to CommentDto
//                .collect(Collectors.toList());
//
//        return new PostDto(
//                post.getUser().getId(),
//                post.getId(),
//                post.getTitle(),
//                post.getContent(),
//                post.getLikes(),
//                commentDto
//        );

//    }
    @Override
    public Post toPost(PostDto postDto) {
        return null;
    }


}
