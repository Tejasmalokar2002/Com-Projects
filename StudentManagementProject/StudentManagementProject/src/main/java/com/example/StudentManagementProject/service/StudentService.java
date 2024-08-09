package com.example.StudentManagementProject.service;


import com.example.StudentManagementProject.dto.StudentDto;
import com.example.StudentManagementProject.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(Student student);

    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudent();

    StudentDto updateStudent(Long studentId, StudentDto updateStudent);

    void deleteStudent(Long studentId);
}
