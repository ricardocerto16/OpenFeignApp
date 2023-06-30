package com.example.personfeign.adpter.mapper;

import com.example.personfeign.adpter.in.dto.request.PersonRequest;
import com.example.personfeign.adpter.in.dto.response.PersonResponse;
import com.example.personfeign.adpter.out.repository.PersonEntity;
import com.example.personfeign.core.model.PersonModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {

        @Mapping(source = "id", target = "id")
        @Mapping(source = "name", target = "name")
        @Mapping(source = "age", target = "age")
        @Mapping(source = "country", target = "country")
        PersonEntity personToPersonEntity(PersonModel personModel);

        @Mapping(source = "id", target = "id")
        @Mapping(source = "name", target = "name")
        @Mapping(source = "age", target = "age")
        @Mapping(source = "country", target = "country")
        PersonModel personEntityToPerson(PersonEntity personEntity);

        @Mapping(source = "name", target = "name")
        @Mapping(source = "age", target = "age")
        @Mapping(source = "country", target = "country")
        PersonModel personRequestToPerson(PersonRequest personRequest);

        List<PersonEntity> personModelToPersonEntityList(List<PersonModel> personModels);


        List<PersonModel> personEntityToPersonModelList(List<PersonEntity> personEntities);


        List<PersonResponse> personListToPersonResponseList(List<PersonModel> all);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        PersonEntity partialUpdate(PersonModel personModel, @MappingTarget PersonEntity personEntity);

        PersonResponse toResponse(PersonModel personModel);

}



