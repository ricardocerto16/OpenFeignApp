package com.example.personfeign.adpter.out.persistence;

import com.example.personfeign.adpter.mapper.PersonMapper;
import com.example.personfeign.adpter.out.repository.PersonEntity;
import com.example.personfeign.adpter.out.repository.PersonRepository;
import com.example.personfeign.core.model.PersonModel;
import com.example.personfeign.core.port.out.PersonPersistance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PersonPersistanceImpl implements PersonPersistance {


    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    @Override
    public Optional<PersonModel> findById(int id) {
        Optional<PersonModel> response = Optional.empty();
        Optional<PersonEntity> opPerson = personRepository.findById(id);

        if (opPerson.isPresent()) {
            response = Optional.ofNullable(personMapper.personEntityToPerson(opPerson.get()));
        }
        return response;
    }

    @Override
    public List<PersonModel> findAll() {
        List<PersonModel> personModelList;

        List<PersonEntity> pagedResult = personRepository.findAll();
        personModelList = personMapper.personEntityToPersonModelList(pagedResult);


        return personModelList;
    }

    @Override
    public Optional<PersonModel> save(PersonModel personModel) {
        PersonEntity personEntity = personMapper.personToPersonEntity(personModel);
        return Optional.of(personMapper.personEntityToPerson(personRepository.save(personEntity)));
    }

    @Override
    public Optional<PersonModel> updateById(int id, PersonModel updatePersonModel) {
        Optional<PersonModel> personModel = Optional.empty();
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);

        if (optionalPersonEntity.isPresent()) {
            personModel = Optional.of(personMapper.personEntityToPerson(personRepository.save(personMapper.partialUpdate(updatePersonModel, optionalPersonEntity.get()))));
        }

        return personModel;
    }

    @Override
    public int deleteById(int id) {
        int result = 0;
        if (personRepository.findById(id).isPresent()){
            personRepository.deleteById(id);
            result = 1;
        }

        return result;
    }
}
