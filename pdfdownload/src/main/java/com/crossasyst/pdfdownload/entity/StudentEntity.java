package com.crossasyst.pdfdownload.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class StudentEntity {
    @Id
    @SequenceGenerator(name = "seq_student_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "seq_student_id")
    private Long id;
    private String studentName;
    private String email;
    private String mobileNo;

}