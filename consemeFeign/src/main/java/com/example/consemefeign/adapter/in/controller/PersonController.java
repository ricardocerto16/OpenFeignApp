package com.example.consemefeign.adapter.in.controller;

import com.example.consemefeign.adapter.in.client.PersonAPI;
import com.example.consemefeign.adapter.in.dto.PersonDTO;
import com.example.consemefeign.adapter.mapper.PersonMapper;
import com.example.consemefeign.core.port.in.PersonOperations;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name="Person Feign")
@RequestMapping("/feign/users")
public class PersonController {

    private final PersonMapper personMapper;
    private final PersonOperations personOperations;

    private final PersonAPI personAPI;

    @GetMapping
    @Operation(summary = "Get all Persons.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Request has been accepted for processing"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public List<PersonDTO> getAllUsers(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language) {
        //return personMapper.personDTOtoPersonlist(personOperations.findAll());
        return personAPI.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a Person by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Request has been accepted for processing"),
            @ApiResponse(responseCode = "404", description = "Request id not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public PersonDTO getUserById(@PathVariable int id) {
        //return personMapper.personToPersonDTO(personOperations.findById(id).get());
        return personAPI.findById(id).get();
    }

}
