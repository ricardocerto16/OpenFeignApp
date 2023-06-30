package com.example.personfeign.adpter.out.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private int age;

    @Column(name = "Country")
    private String country;

}
