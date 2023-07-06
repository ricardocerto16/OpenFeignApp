package com.example.personfeign.adpter.in.controller;

import com.example.personfeign.adpter.in.dto.request.PersonRequest;
import com.example.personfeign.adpter.in.dto.response.PersonResponse;
import com.example.personfeign.adpter.mapper.PersonMapper;
import com.example.personfeign.core.model.PersonModel;
import com.example.personfeign.core.port.in.PersonOperations;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/person")
public class PersonController {

    private final PersonMapper personMapper;
    private final PersonOperations personOperations;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponse> findAll() {
        return personMapper.personListToPersonResponseList(personOperations.findAll());
    }

    @GetMapping("/{id}")
    public PersonResponse findById(@PathVariable int id){
        Optional<PersonModel> personModelOptional = personOperations.findById(id);
        return personMapper.toResponse(personModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id){
        return personOperations.deleteById(id);
    }

    @PostMapping
    public PersonResponse save(@Validated @RequestBody PersonRequest personRequest){
        return personMapper.toResponse(personOperations.save(personMapper.personRequestToPerson(personRequest)).get());

    }

    @PutMapping("/{id}")
    public PersonResponse updateById(@PathVariable Integer id, @RequestBody PersonRequest personRequest) throws Exception {


        Optional<PersonModel> serviceResponse = personOperations.updateById(id, personMapper.personRequestToPerson(personRequest));

        return personMapper.toResponse(serviceResponse.get());

    }



}
