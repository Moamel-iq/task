package com.task.MapStruct.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MapS {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id ;


    private String name;
}
