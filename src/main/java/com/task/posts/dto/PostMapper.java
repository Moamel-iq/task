package com.task.posts.dto;

import com.task.comments.dto.CommentDto;
import com.task.comments.entity.Comment;
import com.task.likes.dto.LikeDto;
import com.task.likes.entity.Like;
import com.task.posts.entity.Post;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//Moamel
@Mapper
public interface PostMapper {
    PostDto toDto(Post post);
    Post toPost(PostDto postDto);



//    default List<PostDto> toDtoList(List<Post> posts) {
//        return posts.stream().map(this::toDto).collect(Collectors.toList());
//    }
//
//    default List<Post> toEntityList(List<PostDto> postDto) {
//        return postDto.stream().map(this::toPost).collect(Collectors.toList());
//    }

//    default List<CommentDto> mapComments(List<Comment> comments) {
//        return comments.stream().map(new Function<Comment, CommentDto>() {
//            @Override
//            public CommentDto apply(Comment comment) {
//                return new CommentDto(comment.getContent());
//            }
//        }).collect(Collectors.toList());
//    }
//    default List<LikeDto> mapLikes(List<Like> likes) {
//        return likes.stream().map(new Function<Like, LikeDto>() {
//            @Override
//            public LikeDto apply(Like like) {
//                return new LikeDto(like.getLike());
//            }
//        }).collect(Collectors.toList());
//    }

}

