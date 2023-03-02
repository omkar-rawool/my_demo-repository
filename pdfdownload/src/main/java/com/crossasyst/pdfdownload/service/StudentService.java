package com.crossasyst.pdfdownload.service;


import java.util.List;
import com.crossasyst.pdfdownload.entity.StudentEntity;
import com.crossasyst.pdfdownload.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(StudentEntity studentEntity) {
        studentRepository.save(studentEntity);
    }

    public List<StudentEntity> getStudentList() {
        return studentRepository.findAll();
    }
}