package com.example.StudentManagementProject.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {


    private Long id;
    private LocalDate enrollmentDate;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String branch;
    private String mobileNumber;
    private String email;
    private String address;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
