package com.example.StudentManagementProject.repository;

import com.example.StudentManagementProject.entity.FileRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRecordRepository extends JpaRepository<FileRecord, Long> {
}
