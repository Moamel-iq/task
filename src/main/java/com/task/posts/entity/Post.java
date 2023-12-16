package com.task.posts.entity;


import com.task.comments.entity.Comment;
import com.task.likes.entity.Like;
import com.task.users.entity.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;


import java.time.Instant;
import java.util.List;

//BY RIDHA
@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @SequenceGenerator(
            name = "posts_sequence",
            sequenceName = "posts_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "posts_sequence")
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @Column(updatable = false)
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Nullable
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Image> images;
    @Nullable
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Nullable
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Like> likes;

    public Integer getLikes(){
        assert likes != null;
        return likes.size();
    }

    public Post(String title, String content, User user) {
        this.title=title;
        this.content=content;
        this.user=user;
    }


    @PrePersist
    public void setCreatedAt(){
        this.createdAt=Instant.now();
    }

    public Post() {
    }
    public Post(String title,String content){
        this.title= title;
        this.content=content;
    }

    public Post(Long id, String title, String content,
                Instant createdAt, User user, List<Image> images, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
        this.images = images;
        this.comments = comments;
    }
}
