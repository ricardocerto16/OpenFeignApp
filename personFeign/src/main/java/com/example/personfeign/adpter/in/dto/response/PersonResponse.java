package com.example.personfeign.adpter.in.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonResponse {

    private int id;
    private String name;
    private int age;
    private String country;
}
