package com.task.posts.dto;
import com.task.posts.entity.Post;
import com.task.posts.request.PostRegistrationRequest;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Repository;
import java.time.Duration;
import java.time.Instant;

@Repository("PostMapperImp")
public class PostMapperImp implements PostMapper{

    @Override
    public PostDto toDto(Post post) {
        if (post == null) {
            return null;
        }
        Instant now = Instant.now();
        Duration duration = Duration.between(post.getCreatedAt(), now);
        String timeAgo;
        if (duration.toDays() > 365) {
            timeAgo = duration.toDays() / 365 + " years ago";
        } else if (duration.toDays() > 30) {
            timeAgo = duration.toDays() / 30 + " months ago";
        } else if (duration.toDays() > 7) {
            timeAgo = duration.toDays() / 7 + " weeks ago";
        } else if (duration.toDays() > 0) {
            timeAgo = duration.toDays() + " days ago";
        } else if (duration.toHours() > 0) {
            timeAgo = duration.toHours() + " hours ago";
        } else if (duration.toMinutes() > 0) {
            timeAgo = duration.toMinutes() + " minutes ago";
        } else {
            timeAgo = "just now";
        }
        return new PostDto(
                timeAgo,
                post.getUser().getId(),
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getLikes()
        );
    }

    @Override
    public void updatePostFromDto(PostDto postDto, @MappingTarget Post post) {
        if (postDto == null) {
            return;
        }
        post.setTitle(postDto.title());
        post.setContent(postDto.content());
    }


    @Override
    public PostDto toDto(PostRegistrationRequest request) {
        if (request == null) {
            return null;
        }
        return new PostDto(
                null,
                null,
                null,
                request.title(),
                request.content(),
                null
        );
    }
}




