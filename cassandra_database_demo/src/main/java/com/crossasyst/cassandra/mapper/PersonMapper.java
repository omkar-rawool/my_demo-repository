package com.crossasyst.cassandra.mapper;

import com.crossasyst.cassandra.entity.PersonEntity;
import com.crossasyst.cassandra.model.PersonRequest;
import com.crossasyst.cassandra.model.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonResponse entityToModel(PersonEntity personEntity);

    PersonEntity modelToEntity(PersonRequest personRequest);

    List<PersonResponse> entitiesToModel(List<PersonEntity> personEntity);

}

