package com.rakbank.employeeRegistration.repository;


import com.rakbank.employeeRegistration.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByEmployeeName(String employeeName);
}
