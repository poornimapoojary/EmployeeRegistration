package com.rakbank.employeeregistration.controller;

import com.rakbank.employeeregistration.entity.Department;
import com.rakbank.employeeregistration.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/departments")
	public List<Department> getDepartmentList() {
		return departmentRepository.findAll();
	}
}
