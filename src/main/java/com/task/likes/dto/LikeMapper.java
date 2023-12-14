package com.task.likes.dto;

import com.task.likes.entity.Like;

public class LikeMapper {
    public static LikeDto toDto(Like like) {
        return new LikeDto();
    }
}
