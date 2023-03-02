package com.crossasyst.opencsv.repository;

import com.crossasyst.opencsv.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

}
