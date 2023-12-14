package com.task.likes.dto;

import com.task.likes.entity.Like;
import org.springframework.stereotype.Repository;

@Repository("LikeMapperImpl")
public class LikeMapperImp implements LikeMapper{
    @Override
    public LikeDto likeDto(Like like) {
        if(like == null){
            return null;
        }
        return new LikeDto(
                like.getPost().getId(),
                like.getUser().getId(),
                like.getPost().getLikes()
        );
    }
}
