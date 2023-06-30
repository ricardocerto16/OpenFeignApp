package com.example.consemefeign.core.port.in;

import com.example.consemefeign.core.model.PersonModel;

import java.util.List;
import java.util.Optional;

public interface PersonOperations {

    Optional<PersonModel> findById(int id);
    List<PersonModel> findAll();
    Optional<PersonModel> save(PersonModel personModel);
    int deleteById(int id);
}
