package com.task.users.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.Instant;

//Moamel
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
    @Column(name = "user_name",length = 50)
    private String name;

    @Column(name = "user_image",length = 50)
    private String image;
    @Column(name = "user_email",nullable = false,unique = true)
    private String email;

    @Column(name = "user_phone")
    private String phone;

    private Instant createdAt;
    private Instant updatedAt;


    public User(Long id, String name,  String email , String image, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
        this.phone = phone;
    }

    @PrePersist
    public void setCreatedAt(){
        this.createdAt=Instant.now();
    }

    @PreUpdate
    public void setUpdatedAt(){
        this.updatedAt=Instant.now();
    }

    public User() {
    }

    public User(
            String name,
            String email,String image, String phone
            ) {

        this.name = name;
        this.email = email;
        this.image = image;
        this.phone = phone;
    }


}
