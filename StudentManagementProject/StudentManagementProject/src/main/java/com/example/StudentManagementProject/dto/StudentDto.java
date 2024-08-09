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
    private LocalDate enrollmentDate; // Updated to LocalDate
    private String firstName;
    private String lastName;
    private LocalDate dob; // Updated to LocalDate
    private String gender;
    private String branch; // Updated to branch
    private String mobileNumber; // Updated to String
    private String email;
    private String address;

    // Optional: Add createdAt and updatedAt if you need them in the DTO
    private LocalDateTime createdAt; // Optional
    private LocalDateTime updatedAt; // Optional
}
