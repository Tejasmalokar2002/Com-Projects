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
//            return null;
//        }
//
//        return new StudentDto(
//                student.getId(),
//                student.getEnrollmentDate(),
//                student.getFirstName(),
//                student.getLastName(),
//                student.getDob(),
//                student.getGender(),
//                student.getBranch(),
//                student.getMobileNumber(),
//                student.getEmail(),
//                student.getAddress(),
//                student.getCreatedAt(),
//                student.getUpdatedAt()
//        );
    }

    public static Student mapToStudent(StudentDto studentDto) {
        if (studentDto == null) {
            return null;
        }

        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setDob(studentDto.getDob());
        student.setGender(studentDto.getGender());
        student.setMobileNumber(studentDto.getMobileNumber());
        student.setEmail(studentDto.getEmail());
        student.setAddress(studentDto.getAddress());
        student.setEnrollmentDate(studentDto.getEnrollmentDate());
        student.setBranch(studentDto.getBranch());
        student.setCreatedAt(studentDto.getCreatedAt());
        student.setUpdatedAt(studentDto.getUpdatedAt());

        return student;
    }

}