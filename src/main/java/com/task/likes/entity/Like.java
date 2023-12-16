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


    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Like() {
    }

    public Like( User user, Post post) {

        this.user = user;
        this.post = post;
    }



}
