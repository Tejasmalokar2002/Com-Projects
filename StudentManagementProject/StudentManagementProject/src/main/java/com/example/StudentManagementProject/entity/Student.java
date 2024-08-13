package com.example.StudentManagementProject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Student_Management")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String mobileNumber;
    private String email;
    private String address;
    private LocalDate enrollmentDate;
    private String branch;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "student")  // Ensure this matches the field name in FileRecord
    private List<FileRecord> files; // One-to-many relationship

    // Constructors, Getters, Setters
}
