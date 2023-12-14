package com.task.likes.dto;

import com.task.likes.entity.Like;
import org.mapstruct.Mapper;

@Mapper
public interface LikeMapper {
    LikeDto likeDto(Like like);

}
