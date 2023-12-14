package com.task.likes.dao;

import org.springframework.stereotype.Repository;

@Repository("Jpa")
public class LikeJpa implements LikeDao{
    private final LikeRepository likeRepository;

    public LikeJpa(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

//    @Override
//    public int getAllLikes() {
//        return likeRepository.findAll().size();
//    }
//
//    @Override
//    public boolean like(Long id) {
//        return likeRepository.findById(id).isPresent();
//    }

}
