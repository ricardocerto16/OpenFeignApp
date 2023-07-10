package com.example.personfeign.adpter.in.controller;

import com.example.personfeign.adpter.in.dto.request.PersonRequest;
import com.example.personfeign.adpter.in.dto.response.PersonResponse;
import com.example.personfeign.adpter.mapper.PersonMapper;
import com.example.personfeign.core.model.PersonModel;
import com.example.personfeign.core.port.in.PersonOperations;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="Person")
@RequestMapping("api/person")
public class PersonController {

    private final PersonMapper personMapper;
    private final PersonOperations personOperations;


    @GetMapping
    @Operation(summary = "Get all Persons.")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Request has been accepted for processing"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public List<PersonResponse> findAll() {
        return personMapper.personListToPersonResponseList(personOperations.findAll());
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Request has been accepted for processing"),
            @ApiResponse(responseCode = "404", description = "Request id not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @Operation(summary = "Get Person By ID.")
    public PersonResponse findById(@PathVariable int id){
        Optional<PersonModel> personModelOptional = personOperations.findById(id);
        return personMapper.toResponse(personModelOptional.get());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Person.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Request has been accepted for processing"),
            @ApiResponse(responseCode = "404", description = "Request id not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public int deleteById(@PathVariable int id){
        return personOperations.deleteById(id);
    }

    @PostMapping
    @Operation(summary = "Save Person.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "new resource have been successfully created"),
            @ApiResponse(responseCode = "400", description = "Request information is wrong")})
    public PersonResponse save(@Validated @RequestBody PersonRequest personRequest){
        return personMapper.toResponse(personOperations.save(personMapper.personRequestToPerson(personRequest)).get());

    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Request has been accepted for processing"),
            @ApiResponse(responseCode = "400", description = "Request information is wrong"),
            @ApiResponse(responseCode = "404", description = "Request id not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @Operation(summary = "Update Person By ID.")
    public PersonResponse updateById(@PathVariable Integer id, @RequestBody PersonRequest personRequest) throws Exception {


        Optional<PersonModel> serviceResponse = personOperations.updateById(id, personMapper.personRequestToPerson(personRequest));

        return personMapper.toResponse(serviceResponse.get());

    }



}
