package com.mappingdemo.mapping.repository;

import com.mappingdemo.mapping.entity.PersonEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CassandraRepository<PersonEntity, Long> {
}
