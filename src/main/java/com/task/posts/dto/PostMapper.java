package com.task.posts.dto;

import com.task.comments.dto.CommentDto;
import com.task.comments.entity.Comment;
import com.task.likes.dto.LikeDto;
import com.task.likes.entity.Like;
import com.task.posts.entity.Post;
import com.task.posts.request.PostRegistrationRequest;
import com.task.posts.request.PostUpdateRequest;
import org.mapstruct.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//Moamel
@Mapper
public interface PostMapper {

    PostDto toDto(Post post);//convert the post entity to dto
    void updateToPost(PostUpdateRequest request , @MappingTarget Post post);

}





