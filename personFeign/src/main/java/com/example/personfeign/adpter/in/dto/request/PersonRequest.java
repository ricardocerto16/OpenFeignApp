package com.example.personfeign.adpter.in.dto.request;

import lombok.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonRequest {


    @NotNull
    private String name;

    @NotNull
    private int age;

    @NotNull
    private String country;

}
