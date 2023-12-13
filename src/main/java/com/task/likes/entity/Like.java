package com.task.likes.entity;


import com.task.posts.entity.Post;
import com.task.users.entity.User;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Like {
    @Id
    @GeneratedValue(generator = "like_sequence",strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="like_status")
    boolean isLike;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Like() {
    }

    public Like(boolean isLike, User user, Post post) {
        this.isLike = isLike;
        this.user = user;
        this.post = post;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
