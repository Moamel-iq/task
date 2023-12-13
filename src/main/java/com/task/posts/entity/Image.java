package com.task.posts.entity;


import jakarta.persistence.*;
//BY RIDHA

@Entity
public class Image {
    @Id
    @SequenceGenerator(
            name = "image_sequence",
            sequenceName = "image_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "image_sequence")

    private Long id;


    private String ImageUrl;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Image() {
    }

    public Image(String imageUrl, Post post) {
        ImageUrl = imageUrl;
        this.post = post;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
