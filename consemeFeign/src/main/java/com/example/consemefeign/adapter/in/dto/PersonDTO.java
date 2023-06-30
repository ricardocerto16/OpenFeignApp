package com.example.consemefeign.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("age")
    private int age;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;

}
