package com.task.users.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(
            name ="user_id_sequence" ,
            sequenceName = "user_id_sequence",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "user_name",length = 50,nullable = false)
    private String name;

    @Column(name = "user_image",length = 50)
    private String image;
    @Column(name = "user_email",nullable = false,unique = true)
    private String email;

    @Column(name = "user_phone",unique = true)
    private String phone;

    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    public void setCreatedAt(){
        this.createdAt=Instant.now();
    }

    @PreUpdate
    public void setUpdatedAt(){
        this.updatedAt=Instant.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public User() {
    }

    public User(
            Long id, String name, String image,
            String email, String phone,
            Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
