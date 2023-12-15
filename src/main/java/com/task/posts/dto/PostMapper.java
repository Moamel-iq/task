package com.task.posts.dto;

import com.task.comments.dto.CommentDto;
import com.task.comments.entity.Comment;
import com.task.likes.dto.LikeDto;
import com.task.likes.entity.Like;
import com.task.posts.entity.Post;
import com.task.posts.request.PostRegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//Moamel
@Mapper
public interface PostMapper {
    PostDto toDto(Post post);//convert the post entity to dto
    void updatePostFromDto(PostDto postDto, @MappingTarget Post post);// used to update an existing Post entity with the values from a PostDto
    PostDto toDto(PostRegistrationRequest request);//convert the PostRegistrationRequest to post dto
}





