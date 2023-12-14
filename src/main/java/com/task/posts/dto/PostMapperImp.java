package com.task.posts.dto;

import com.task.posts.entity.Post;
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
                mapComments(post.getComments())

        );
    }


    @Override
    public Post toPost(PostDto postDto) {
        return null;
    }
}
