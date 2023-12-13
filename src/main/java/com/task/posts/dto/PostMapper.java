package com.task.posts.dto;

import com.task.posts.entity.Post;

public class PostMapper {
   public PostDto toDto(Post post ){
       return new PostDto(
               post.getTitle(),
               post.getContent()

       );
   }
}


