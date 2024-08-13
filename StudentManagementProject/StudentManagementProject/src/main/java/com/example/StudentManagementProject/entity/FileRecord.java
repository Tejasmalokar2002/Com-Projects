package com.example.StudentManagementProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FileRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long fileId;

    private String fileName;
    private String fileExtension;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false) // Updated column name
    private Student student;
    // Constructors, Getters, Setters
}
