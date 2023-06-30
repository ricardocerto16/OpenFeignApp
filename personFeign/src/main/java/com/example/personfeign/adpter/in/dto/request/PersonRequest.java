package com.example.personfeign.adpter.in.dto.request;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonRequest {


    @NotNull
    private String name;
    private int age;
    private String country;

}
