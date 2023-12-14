package com.task.posts.dto;

import com.task.posts.entity.Post;
import com.task.users.entity.User;
import org.springframework.stereotype.Repository;

@Repository("PostMapperImp")
public class PostMapperImp implements PostMapper{

    @Override
    public PostDto toDto(Post post) {
        if (post == null ){
            return null;
        }
        return new PostDto(
                post.getTitle(),
                post.getContent(),
                post.getId()
        );
    }


    @Override
    public Post toPost(PostDto postDto) {
        return null;
    }
}
