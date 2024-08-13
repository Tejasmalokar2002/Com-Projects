package com.example.StudentManagementProject.controller;

import com.example.StudentManagementProject.entity.FileRecord;
import com.example.StudentManagementProject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload/{id}")
    public ResponseEntity<Object> uploadFile(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File must not be empty.");
        }

        FileRecord fileRecord = fileService.saveFile(file, id);
        return ResponseEntity.ok(fileRecord);
    }

    @GetMapping("/download/file/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) throws IOException {
        FileRecord fileRecord = fileService.getFileRecord(id);
        byte[] fileData = fileService.getFileData(id); // Fetch the actual file data
        String fileName = fileRecord.getFileName();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .body(fileData);
    }

    @GetMapping("/download/excel")
    public ResponseEntity<byte[]> downloadAllStudentsExcel() throws IOException {
        byte[] fileData = fileService.generateExcelForAllStudents();
        String fileName = "student_records.xlsx";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .body(fileData);
    }

    @GetMapping("/download/pdf")
    public ResponseEntity<byte[]> downloadAllStudentsPdf() throws IOException {
        byte[] fileData = fileService.generatePdfForAllStudents();
        String fileName = "student_records.pdf";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .body(fileData);
    }
}
