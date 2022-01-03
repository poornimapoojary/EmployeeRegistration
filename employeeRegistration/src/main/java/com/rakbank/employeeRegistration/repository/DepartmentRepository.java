package com.rakbank.employeeRegistration.repository;

import com.rakbank.employeeRegistration.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

}
