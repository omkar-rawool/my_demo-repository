package com.mapping.demo.mapper;


import com.mapping.demo.entity.PersonEntity;
import com.mapping.demo.model.PersonRequest;
import com.mapping.demo.model.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper
{
    PersonMapper INSTANCE= Mappers.getMapper(PersonMapper.class);

  PersonResponse entityToModel(PersonEntity personEntity);

  PersonEntity modelToEntity(PersonRequest personRequest);

  List<PersonResponse> modelToEntities(List<PersonEntity> personEntity);

//  PersonResponse entityToModelResponse(PersonEntity personEntity);
}
