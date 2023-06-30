package com.example.consemefeign.adapter.in.controller;

import com.example.consemefeign.adapter.in.client.PersonAPI;
import com.example.consemefeign.adapter.in.dto.PersonDTO;
import com.example.consemefeign.adapter.mapper.PersonMapper;
import com.example.consemefeign.core.port.in.PersonOperations;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/feign/users")
public class PersonController {

    private final PersonMapper personMapper;
    private final PersonOperations personOperations;

    private final PersonAPI personAPI;

    @GetMapping
    public List<PersonDTO> getAllUsers(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language) {
        //return personMapper.personDTOtoPersonlist(personOperations.findAll());
        return personAPI.findAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getUserById(@PathVariable int id) {
        //return personMapper.personToPersonDTO(personOperations.findById(id).get());
        return personAPI.findById(id).get();
    }

}
