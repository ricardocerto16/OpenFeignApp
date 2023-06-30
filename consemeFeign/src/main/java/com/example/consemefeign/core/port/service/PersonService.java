package com.example.consemefeign.core.port.service;

import com.example.consemefeign.core.model.PersonModel;
import com.example.consemefeign.core.port.in.PersonOperations;
import com.example.consemefeign.core.port.out.PersonPersistance;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService implements PersonOperations {

    private PersonPersistance personPersistance;

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
    public int deleteById(int id) {
        return personPersistance.deleteById(id);
    }
}

