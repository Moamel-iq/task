package com.task.posts.dto;

import com.task.posts.entity.Post;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostMapper implements Function<Post,PostDto> {
    @Override
    public PostDto apply(Post post) {
        return new PostDto(
                post.getTitle(),
                post.getContent());
    }
}

