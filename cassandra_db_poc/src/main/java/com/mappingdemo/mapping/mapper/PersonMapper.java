package com.mappingdemo.mapping.mapper;


import com.mappingdemo.mapping.entity.PersonEntity;
import com.mappingdemo.mapping.model.PersonRequest;
import com.mappingdemo.mapping.model.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper
{
    PersonMapper INSTANCE= Mappers.getMapper(PersonMapper.class);

  PersonResponse entityToModel (PersonEntity personEntity);

  PersonEntity modelToEntity(PersonRequest personRequest);

  List<PersonResponse> modelToEntities(List<PersonEntity> personEntity);

}
