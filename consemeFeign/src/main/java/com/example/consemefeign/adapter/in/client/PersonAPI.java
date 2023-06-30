package com.example.consemefeign.adapter.in.client;

import com.example.consemefeign.adapter.in.dto.PersonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "person-api", url = "http://localhost:8080", path = "/api/person")
public interface PersonAPI {

    @GetMapping("/{id}")
    Optional<PersonDTO> findById(@PathVariable int id);

    @GetMapping
    List<PersonDTO> findAll();
}
