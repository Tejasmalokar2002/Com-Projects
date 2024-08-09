package com.example.StudentManagementProject.repository;


import com.example.StudentManagementProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
