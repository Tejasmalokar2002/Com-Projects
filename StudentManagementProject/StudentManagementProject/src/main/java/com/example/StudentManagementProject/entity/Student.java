package com.example.StudentManagementProject.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Student_Management")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String firstName;


    private String lastName;


    private LocalDate dob; // Use LocalDate for date fields

    // Adjust length as needed
    private String gender;


    private String mobileNumber; // Changed to String to handle phone numbers with leading zeros

    private String email;


    private String address;


    private LocalDate enrollmentDate; // Use LocalDate for date fields


    private String branch; // Renamed from `Branch` to `branch` to follow Java naming conventions

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
