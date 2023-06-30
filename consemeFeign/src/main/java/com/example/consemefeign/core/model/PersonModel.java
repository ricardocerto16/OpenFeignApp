package com.example.consemefeign.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "personFeign")
public class PersonModel {


    public PersonModel() {
    }

    @Id
    private int id;

    private int age;

    private String name;

    private String country;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
