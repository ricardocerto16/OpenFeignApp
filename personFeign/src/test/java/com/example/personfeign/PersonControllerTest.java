package com.example.personfeign;

import com.example.personfeign.adpter.in.controller.PersonController;
import com.example.personfeign.adpter.in.dto.response.PersonResponse;
import com.example.personfeign.adpter.mapper.PersonMapper;
import com.example.personfeign.core.model.PersonModel;
import com.example.personfeign.core.port.in.PersonOperations;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.instancio.Select.fields;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonMapper personMapper;

    @MockBean
    private PersonOperations personOperations;


    @Test
    void findByIdTest() throws Exception {

        int id = 1;
        String name = "Name 01";

        PersonModel personModel = generatePersonModel();

        when(personOperations.findById(id)).thenReturn(Optional.of(personModel));
        when(personMapper.toResponse(any())).thenReturn(Instancio.of(PersonResponse.class).set(fields().named("name"),name).create());

        mockMvc.perform(get("/api/person/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name));

    }

    @Test
    void findAllTest() throws Exception {
        when(personOperations.findAll()).thenReturn(generatePersonModelList(10));
        when(personMapper.personListToPersonResponseList(any())).thenReturn(generateListResponsePerson(10));

        mockMvc.perform(get("/api/person"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(10));

    }


    @Test
    void deleteByIdTest() throws Exception {

        PersonModel personModel = generatePersonModel();
        given(personOperations.deleteById(personModel.getId())).willReturn(1);

        mockMvc.perform(delete("/api/person/{id}", personModel.getId()))
                .andExpect(status().isOk());
    }


    @Test
    void saveTest() throws Exception {
        PersonModel personModel = generatePersonModel();

        when(personOperations.save(personModel)).thenReturn(Optional.of(personModel));
        when(personMapper.personRequestToPerson(any())).thenReturn(personModel);

        mockMvc.perform(post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Person 01\" }"))
                .andExpect(status().is2xxSuccessful()).andDo(print());
    }


    // HOW TO TEST UPDATE IF METHOD IS DEFINED IN CONTROLLER
   /* @Test
    void updateByIdTest() throws Exception {

        PersonModel personModel = generatePersonModel();
        PersonResponse personResponse = generatePersonResponse();

        when(personOperations.findById(anyInt())).thenReturn(Optional.of(personModel));
        when(personMapper.personRequestToPerson(any())).thenReturn(personModel);
        when(personOperations.updateById(anyInt(),any())).thenReturn(Optional.of(personModel));
        when(personMapper.toResponse(any())).thenReturn(personResponse);

        given(personOperations.findById(personModel.getId())).willReturn(Optional.of(personModel));

        mockMvc.perform(put("/api/person/{id}", personModel.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Person 01\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(personModel.getId()));
    }

*/

    private PersonModel generatePersonModel() {
        return generatePersonModelList(1).get(0);
    }

    private List<PersonModel> generatePersonModelList(int size) {
        List<PersonModel> returnList = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            returnList.add(Instancio.of(PersonModel.class)
                    .set(fields().named("id"), i)
                    .create());
        }

        return returnList;
    }

    private PersonResponse generatePersonResponse() {
        return generateListResponsePerson(1).get(0);
    }

    private List<PersonResponse> generateListResponsePerson(int size) {
        List<PersonResponse> returnList = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            returnList.add(Instancio.of(PersonResponse.class)
                    .set(fields().named("id"), i)
                    .create());
        }

        return returnList;

    }

}
