package com.task.posts.entity;


import com.task.comments.entity.Comment;
import com.task.likes.entity.Like;
import com.task.users.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

//BY RIDHA
@Entity
@Table(name = "posts")
@Data
public class post {
    @Id
    @SequenceGenerator(
            name = "posts_sequence",
            sequenceName = "posts_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "posts_sequence")
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(name = "content ",nullable = false)
    private String content;
    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Image> images;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;
    @PrePersist
    public void setCreatedAt(){
        this.createdAt=Instant.now();
    }

    public Post() {
    }

    public Post(String title, String content, List<String> images, User user) {
        this.title = title;
        this.content = content;

        this.createdAt = createdAt;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
