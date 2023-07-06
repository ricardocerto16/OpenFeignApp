package com.example.personfeign;


import com.example.personfeign.core.model.PersonModel;
import com.example.personfeign.core.port.out.PersonPersistance;
import com.example.personfeign.core.service.PersonService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.instancio.Select.fields;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    PersonService personService;

    @Mock
    PersonPersistance personPersistance;

    @Test
    void findByIdTest(){

        PersonModel personModel = generatePersonModel();

        when(personPersistance.findById(anyInt())).thenReturn(Optional.of(personModel));
        Optional<PersonModel> optionalPersonModel = this.personService.findById(1);

        assertEquals(personModel.getId(), optionalPersonModel.get().getId());

        assertTrue(optionalPersonModel.isPresent());
        verify(personPersistance).findById(1);
    }


    @Test
    void saveTest(){
        PersonModel personModel = generatePersonModel();

        when(personService.save(any(PersonModel.class))).thenReturn(Optional.of(personModel));

        Optional<PersonModel> savedPerson = personService.save(personModel);
        assertTrue(savedPerson.isPresent());
    }

    @Test
    void updateByIdTest(){
        PersonModel personModel = generatePersonModel();
        Optional<PersonModel> newPersonModel = personPersistance.findById(personModel.getId());

        personService.updateById(personModel.getId(), personModel);

        if (newPersonModel.isPresent()){
            assertEquals(personModel.getId(), newPersonModel.get().getId());
            verify(personPersistance).save(newPersonModel.get());
        }

        verify(personPersistance).findById(personModel.getId());

    }


    @Test
    void deletedByIdTest(){
        int deleted_sucess = 1;
        PersonModel personModel = generatePersonModel();

        when(personPersistance.deleteById(anyInt())).thenReturn(deleted_sucess);
        personService.deleteById(personModel.getId());

        verify(personPersistance).deleteById(personModel.getId());
    }


    @Test
    void findAllTest(){

        when(personPersistance.findAll()).thenReturn(generatePersonModelList(10));
        List<PersonModel> pageModel = this.personService.findAll();

        assertFalse(pageModel.isEmpty());
        verify(this.personPersistance).findAll();

    }

    private PersonModel generatePersonModel() {
        PersonModel personModel = new PersonModel();
        personModel.setId(1);
        personModel.setName("name");

        return Instancio.create(PersonModel.class);
    }

    private List<PersonModel> generatePersonModelList(int size) {
        List<PersonModel> personModelList = new ArrayList<>();

        for (int i = 0 ; i < size ; i++){
            personModelList.add(Instancio.of(PersonModel.class)
                    .set(fields().named("id"),i)
                    .create());
        }
        return personModelList;
    }


}
