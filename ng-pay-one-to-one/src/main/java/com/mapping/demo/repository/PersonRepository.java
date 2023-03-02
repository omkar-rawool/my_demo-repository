package com.mapping.demo.repository;

import com.mapping.demo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends JpaRepository <PersonEntity,Long> {
}
