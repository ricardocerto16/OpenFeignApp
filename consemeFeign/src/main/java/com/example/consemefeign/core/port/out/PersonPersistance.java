package com.example.consemefeign.core.port.out;

import com.example.consemefeign.adapter.in.dto.PersonDTO;
import com.example.consemefeign.core.model.PersonModel;

import java.util.List;
import java.util.Optional;

public interface PersonPersistance {

    Optional<PersonModel> findById(int id);
    List<PersonModel> findAll();
    Optional<PersonModel> save(PersonModel personModel);
    int deleteById(int id);
}
