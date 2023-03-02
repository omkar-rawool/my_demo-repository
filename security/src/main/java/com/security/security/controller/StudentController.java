package com.security.security.controller;


import com.security.security.service.StudentService;
import com.security.security.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("hello/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId)
    {
        return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatus.OK);
    }
}