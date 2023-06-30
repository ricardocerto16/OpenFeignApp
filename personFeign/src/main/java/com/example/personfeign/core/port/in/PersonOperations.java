package com.example.personfeign.core.port.in;

import com.example.personfeign.core.model.PersonModel;

import java.util.List;
import java.util.Optional;

public interface PersonOperations {

    Optional<PersonModel> findById(int id);
    List<PersonModel> findAll();
    Optional<PersonModel> save(PersonModel personModel);
    Optional<PersonModel> updateById(int id, PersonModel personModel);
    int deleteById(int id);

}
