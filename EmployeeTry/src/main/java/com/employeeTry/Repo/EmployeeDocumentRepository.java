package com.employeeTry.Repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeTry.entity.EmployeeDocument;

public interface EmployeeDocumentRepository extends JpaRepository<EmployeeDocument, String> {
}
