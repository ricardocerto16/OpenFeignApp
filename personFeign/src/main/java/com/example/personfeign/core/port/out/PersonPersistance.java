package com.example.personfeign.core.port.out;

import com.example.personfeign.core.model.PersonModel;

import java.util.List;
import java.util.Optional;

public interface PersonPersistance {

    Optional<PersonModel> findById(int id);
    List<PersonModel> findAll();
    Optional<PersonModel> save(PersonModel personModel);
    Optional<PersonModel> updateById(int id, PersonModel personModel);
    int deleteById(int id);

}
