package com.example.consemefeign.adapter.mapper;

import com.example.consemefeign.adapter.in.dto.PersonDTO;
import com.example.consemefeign.core.model.PersonModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "country", target = "country")
    PersonDTO personToPersonDTO(PersonModel personModel);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "country", target = "country")
    PersonModel personDTOtoPerson(PersonDTO personDTO);


    List<PersonDTO> personDTOtoPersonlist(List<PersonModel> personModelList);

    List<PersonModel> persontoPersonDTOlist(List<PersonDTO> personDTOList);
}
