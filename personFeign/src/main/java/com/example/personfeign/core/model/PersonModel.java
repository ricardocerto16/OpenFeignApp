package com.example.personfeign.core.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonModel implements Serializable {

    private int id;
    private String name;
    private int age;
    private String country;

}
