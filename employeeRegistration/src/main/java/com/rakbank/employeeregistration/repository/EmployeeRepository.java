package com.rakbank.employeeregistration.repository;


import com.rakbank.employeeregistration.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByEmployeeName(String employeeName);
}
