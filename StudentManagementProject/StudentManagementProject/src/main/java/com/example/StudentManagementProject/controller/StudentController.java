package com.example.StudentManagementProject.controller;
import com.example.StudentManagementProject.dto.StudentDto;
import com.example.StudentManagementProject.entity.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentController {

    private com.example.StudentManagementProject.service.StudentService studentService;

    //Here I Building Rest API
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody Student student) {
        log.info("student: {}", student);
        StudentDto studentDto = studentService.createStudent(student);
        log.info("student dto: {}", studentDto);
        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
    }

    //Here I Build Get Student Rest API
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId){
        StudentDto studentDto = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDto);
    }

    //Here I Build Get ALl Students REST API
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    //Here I Build Update Student REST API
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId,
                                                    @RequestBody StudentDto updatedStudent){
        StudentDto studentDto = studentService.updateStudent(studentId,updatedStudent);
        return ResponseEntity.ok(studentDto);
    }


    //Here I Build DELETE Student REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}
