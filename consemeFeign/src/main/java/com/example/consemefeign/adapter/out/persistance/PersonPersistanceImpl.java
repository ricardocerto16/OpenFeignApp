package com.example.consemefeign.adapter.out.persistance;

import com.example.consemefeign.adapter.in.client.PersonAPI;
import com.example.consemefeign.adapter.in.dto.PersonDTO;
import com.example.consemefeign.adapter.mapper.PersonMapper;
import com.example.consemefeign.core.model.PersonModel;
import com.example.consemefeign.core.port.out.PersonPersistance;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PersonPersistanceImpl implements PersonPersistance {

    private PersonAPI personAPI;
    private PersonMapper personMapper;

    @Override
    public Optional<PersonModel> findById(int id) {

        Optional<PersonDTO> personDTO = personAPI.findById(id);

        return Optional.ofNullable(personMapper.personDTOtoPerson(personDTO.get()));
    }

    @Override
    public List<PersonModel> findAll() {
        return personMapper.persontoPersonDTOlist(personAPI.findAll());
    }

    @Override
    public Optional<PersonModel> save(PersonModel personModel) {
        return Optional.empty();
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
