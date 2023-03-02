package com.crossasyst.pdfdownload.repository;

import com.crossasyst.pdfdownload.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
