package com.example.StudentManagementProject.service.impl;


import com.example.StudentManagementProject.dto.StudentDto;
import com.example.StudentManagementProject.entity.Student;
import com.example.StudentManagementProject.exception.ResourceNotFoundException;
import com.example.StudentManagementProject.mapper.StudentMapper;
import com.example.StudentManagementProject.repository.StudentRepository;
import com.example.StudentManagementProject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(Student student) {
        Student saveStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(saveStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Student is not exists with given id : " + studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student)-> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updateStudent) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student is not exists with given Id : "+studentId));

        student.setBranch(updateStudent.getBranch());
        student.setFirstName(updateStudent.getFirstName());
        student.setLastName(updateStudent.getLastName());
        student.setMobileNumber(updateStudent.getMobileNumber());
        student.setEnrollmentDate(updateStudent.getEnrollmentDate());
        student.setDob(updateStudent.getDob());
        student.setGender(updateStudent.getGender());
        student.setEmail(updateStudent.getEmail());
        student.setAddress(updateStudent.getAddress());
        student.setCreatedAt(updateStudent.getCreatedAt());
        student.setUpdatedAt(updateStudent.getUpdatedAt());



        Student updatedStudentObj = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Student is not exists with given id : " + studentId));
        studentRepository.deleteById(studentId);
    }
}
