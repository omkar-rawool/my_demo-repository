package com.crossasyst.cassandra.repository;

import com.crossasyst.cassandra.entity.PersonEntity;
import com.crossasyst.cassandra.model.PersonResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends CassandraRepository<PersonEntity, UUID> {
     @AllowFiltering
     PersonEntity getByLastName(String lastName);

     @AllowFiltering
     PersonEntity deleteByLastName(String lastName);
}
