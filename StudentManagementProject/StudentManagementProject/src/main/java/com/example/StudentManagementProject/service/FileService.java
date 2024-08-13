package com.example.StudentManagementProject.service;

import com.example.StudentManagementProject.entity.FileRecord;
import com.example.StudentManagementProject.entity.Student;
import com.example.StudentManagementProject.repository.FileRecordRepository;
import com.example.StudentManagementProject.repository.StudentRepository;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    @Autowired
    private FileRecordRepository fileRecordRepository;

    @Autowired
    private StudentRepository studentRepository;

    private final String fileStoragePath = "path/to/your/storage/directory"; // Update this path

    public FileRecord saveFile(MultipartFile file, Long id) throws IOException {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        FileRecord fileRecord = new FileRecord();
        fileRecord.setFileName(file.getOriginalFilename());
        fileRecord.setFileExtension(getFileExtension(file.getOriginalFilename()));
        fileRecord.setCreatedAt(LocalDateTime.now());
        fileRecord.setStudent(student);

        FileRecord savedFileRecord = fileRecordRepository.save(fileRecord);

        //Path path = Paths.get(fileStoragePath + File.separator + savedFileRecord.getFileId() + "." + fileRecord.getFileExtension());

//        try {
//            Files.write(path, file.getBytes());
//        } catch (IOException e) {
//            throw new IOException("Failed to save file to path: " + path, e);
//        }

        return savedFileRecord;
    }



    public FileRecord getFileRecord(Long id) {
        return fileRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }

    public byte[] getFileData(Long id) throws IOException {
        FileRecord fileRecord = getFileRecord(id);
        Path path = Paths.get(fileStoragePath + File.separator + fileRecord.getFileId() + "." + fileRecord.getFileExtension());

        // Read file content into byte array
        return Files.readAllBytes(path);
    }

    public byte[] generateExcelForAllStudents() throws IOException {
        List<Student> students = studentRepository.findAll();
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Students");

            // Header row
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("First Name");
            header.createCell(2).setCellValue("Last Name");
            header.createCell(3).setCellValue("DOB");
            header.createCell(4).setCellValue("Gender");
            header.createCell(5).setCellValue("Mobile Number");
            header.createCell(6).setCellValue("Email");
            header.createCell(7).setCellValue("Address");
            header.createCell(8).setCellValue("Enrollment Date");
            header.createCell(9).setCellValue("Branch");

            // Data rows
            int rowNum = 1;
            for (Student student : students) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(student.getId());
                row.createCell(1).setCellValue(student.getFirstName());
                row.createCell(2).setCellValue(student.getLastName());
                row.createCell(3).setCellValue(student.getDob().toString());
                row.createCell(4).setCellValue(student.getGender());
                row.createCell(5).setCellValue(student.getMobileNumber());
                row.createCell(6).setCellValue(student.getEmail());
                row.createCell(7).setCellValue(student.getAddress());
                row.createCell(8).setCellValue(student.getEnrollmentDate().toString());
                row.createCell(9).setCellValue(student.getBranch());
            }

            workbook.write(out);
            return out.toByteArray();
        }
    }

    public byte[] generatePdfForAllStudents() throws IOException {
        List<Student> students = studentRepository.findAll();
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();

            // Create a table with 10 columns
            PdfPTable table = new PdfPTable(10);

            // Define column headers
            table.addCell(new PdfPCell(new Paragraph("ID")));
            table.addCell(new PdfPCell(new Paragraph("First Name")));
            table.addCell(new PdfPCell(new Paragraph("Last Name")));
            table.addCell(new PdfPCell(new Paragraph("DOB")));
            table.addCell(new PdfPCell(new Paragraph("Gender")));
            table.addCell(new PdfPCell(new Paragraph("Mobile Number")));
            table.addCell(new PdfPCell(new Paragraph("Email")));
            table.addCell(new PdfPCell(new Paragraph("Address")));
            table.addCell(new PdfPCell(new Paragraph("Enrollment Date")));
            table.addCell(new PdfPCell(new Paragraph("Branch")));

            // Add data rows
            for (Student student : students) {
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(student.getId()))));
                table.addCell(new PdfPCell(new Paragraph(student.getFirstName())));
                table.addCell(new PdfPCell(new Paragraph(student.getLastName())));
                table.addCell(new PdfPCell(new Paragraph(student.getDob().toString())));
                table.addCell(new PdfPCell(new Paragraph(student.getGender())));
                table.addCell(new PdfPCell(new Paragraph(student.getMobileNumber())));
                table.addCell(new PdfPCell(new Paragraph(student.getEmail())));
                table.addCell(new PdfPCell(new Paragraph(student.getAddress())));
                table.addCell(new PdfPCell(new Paragraph(student.getEnrollmentDate().toString())));
                table.addCell(new PdfPCell(new Paragraph(student.getBranch())));
            }

            document.add(table);
            document.close();
            return out.toByteArray();
        } catch (DocumentException e) {
            throw new IOException("Error creating PDF document", e);
        }
    }

    private String getFileExtension(String fileName) {
        int index = fileName.lastIndexOf(".");
        return (index > 0) ? fileName.substring(index + 1) : "";
    }
}
