package com.security.security.service;

import com.security.security.model.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1l, "Omkar rawool"),
            new Student(2l, "Arbaz Shaikh"),
            new Student(3l, "Aryan Singh")
    );
    public Student getStudent(Long studentId)
    {
        return STUDENTS.stream().filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException("Student not found with id: " + studentId));
    }
}