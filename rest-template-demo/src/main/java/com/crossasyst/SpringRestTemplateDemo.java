package com.crossasyst;


import com.crossasyst.model.Student;
import com.mapping.demo.others.MathOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication(scanBasePackages = "com.crossasyst")
public class SpringRestTemplateDemo {

    public static Optional<List<Student>> getPassedStudents(List<Student> studentList) {
        return Optional.of(studentList.stream().filter(s -> "pass".equalsIgnoreCase(s.getStatus())).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRestTemplateDemo.class, args);


        List<Student> studentList = Arrays.asList(
                new Student(1L, "Omkar", "Rawool", "pass"),
                new Student(2L, "Gautam", "Iyer", "pass"),
                new Student(3L, "Kunal", "Dinkar", "pass"),
                new Student(4L, "Aditya", "Mhatre", "fail"),
                new Student(5L, "Varun", "Dhavan", "pass"),
                new Student(6L, "Virat", "Kohli", "fail"),
                new Student(7L, "Vikas", "Pawar", "Pass"),
                new Student(8L, "Rakesh", "Jain", "pass"),
                new Student(9L, "Abhimanyu", "Dey", "fail")
        );

        Object[] objects = studentList.toArray();

      /*  for(Object a: objects)
        {
            System.out.println(a);
        }*/


        System.out.println("+++++++++++++++++++++");

       // System.out.println(Arrays.toString(objects));
        //System.out.println(getPassedStudents(studentList));

       // Optional<List<Student>> pass = Optional.of(studentList.stream().filter(s -> s.getStatus().equals("pass")).collect(Collectors.toList()));
        MathOperation mathOperation = new MathOperation();
        mathOperation.doSum(23,34);
    }
}
