package com.task.posts.entity;


import jakarta.persistence.*;
//BY RIDHA

@Entity
public class Image {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "image_sequence")
    private Long id;


    private String ImageUrl;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private post post;

    public Image() {
    }

    public Image(String imageUrl, com.task.posts.entity.post post) {
        ImageUrl = imageUrl;
        this.post = post;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public com.task.posts.entity.post getPost() {
        return post;
    }

    public void setPost(com.task.posts.entity.post post) {
        this.post = post;
    }
}
