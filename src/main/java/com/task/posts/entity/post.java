package com.task.posts.entity;


import com.task.users.entity.User;
import jakarta.persistence.*;
import lombok.Data;

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
    private Instant createdAt;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Image> images;

    @PrePersist
    public void setCreatedAt(){
        this.createdAt=Instant.now();
    }

    public post() {
    }

    public post(String title, String content, List<String> images, Instant createdAt, User user) {
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
