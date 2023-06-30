package com.example.personfeign.core.service;

import com.example.personfeign.core.model.PersonModel;
import com.example.personfeign.core.port.in.PersonOperations;
import com.example.personfeign.core.port.out.PersonPersistance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService implements PersonOperations {

    private final PersonPersistance personPersistance;

    @Override
    public Optional<PersonModel> findById(int id) {
        return personPersistance.findById(id);
    }

    @Override
    public List<PersonModel> findAll() {
        return personPersistance.findAll();
    }

    @Override
    public Optional<PersonModel> save(PersonModel personModel) {
        return personPersistance.save(personModel);
    }

    @Override
    public Optional<PersonModel> updateById(int id, PersonModel personModel) {
        return personPersistance.updateById(id,personModel);
    }

    @Override
    public int deleteById(int id) {
        return personPersistance.deleteById(id);
    }
}
