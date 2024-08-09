package com.example.StudentManagementProject.mapper;

import com.example.StudentManagementProject.dto.StudentDto;
import com.example.StudentManagementProject.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student) {

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setDob(student.getDob());
        studentDto.setGender(student.getGender());
        studentDto.setMobileNumber(student.getMobileNumber());
        studentDto.setEmail(student.getEmail());
        studentDto.setAddress(student.getAddress());
        studentDto.setEnrollmentDate(student.getEnrollmentDate());
        studentDto.setBranch(student.getBranch());
        studentDto.setCreatedAt(student.getCreatedAt());
        studentDto.setUpdatedAt(student.getUpdatedAt());

        return studentDto;
//        if (student == null) {
//            return null; // Handle null Student
//        }
//
//        return new StudentDto(
//                student.getId(),
//                student.getEnrollmentDate(), // Ensure this is in the correct order
//                student.getFirstName(),
//                student.getLastName(),
//                student.getDob(),
//                student.getGender(),
//                student.getBranch(), // Ensure this is in the correct order
//                student.getMobileNumber(), // Ensure this is in the correct order
//                student.getEmail(),
//                student.getAddress(),
//                student.getCreatedAt(), // Optional
//                student.getUpdatedAt()  // Optional
//        );
    }

    public static Student mapToStudent(StudentDto studentDto) {
        if (studentDto == null) {
            return null; // Handle null StudentDto
        }

        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getDob(),
                studentDto.getGender(),
                studentDto.getMobileNumber(),
                studentDto.getEmail(),
                studentDto.getAddress(),
                studentDto.getEnrollmentDate(),
                studentDto.getBranch(),
                studentDto.getCreatedAt(),
                studentDto.getUpdatedAt()
        );
    }
}
