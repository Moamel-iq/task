package com.task.likes.service;

import com.task.likes.dao.LikeDao;
import com.task.likes.dto.LikeMapper;

public class LikeService {
    private final LikeDao likeDao;
    private final LikeMapper likeMapper;

    public LikeService(LikeDao likeDao, LikeMapper likeMapper) {
        this.likeDao = likeDao;
        this.likeMapper = likeMapper;
    }

//    public int getAllLikes() {
//        return likeDao.getAllLikes();
//    }
}
