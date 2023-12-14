package com.task.likes.entity;


import com.task.posts.entity.Post;
import com.task.users.entity.User;
import jakarta.persistence.*;
import lombok.Data;

//By Ridha
@Entity
@Data
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "like_id_seq" , sequenceName = "like_id_seq")
    private Long id;

    @Column(name="like_status")
    boolean isLike;

    @ManyToOne
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
