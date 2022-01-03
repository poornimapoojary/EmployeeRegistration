package com.rakbank.employeeRegistration.controller;

import com.rakbank.employeeRegistration.entity.Employee;
import com.rakbank.employeeRegistration.exception.ResourceNotFoundException;
import com.rakbank.employeeRegistration.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  EmployeeController class having all end-points for CRUD operations
 * @author Poornima Poojary
 * @version 1.0
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		logger.info("listing all Employee details");
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		logger.info("getting the Employee with Employee Number: {}",employeeId);
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for id:: "+employeeId));
		return ResponseEntity.ok().body(employee);
	}
	
	@GetMapping("/employee/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable(value = "name") String employeeName)
			throws ResourceNotFoundException {
		logger.info("getting the Employee with Employee Name: {}",employeeName);
		List<Employee> employeeList = employeeRepository.findByEmployeeName(employeeName);
		if(employeeList.isEmpty()) {
			throw new ResourceNotFoundException("Employee not found for name:: "+employeeName);
		}
		return ResponseEntity.ok().body(employeeList);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		logger.info("adding new Employee: {}",employee);
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		logger.info("updating the Employee with Employee Number: {}",employeeId);
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for id:: "+employeeId));

		employee.setEmployeeNo(employeeDetails.getEmployeeNo());
		employee.setEmployeeName(employeeDetails.getEmployeeName());
		employee.setDateOfJoining(employeeDetails.getDateOfJoining());
		employee.setDepartment(employeeDetails.getDepartment());
		employee.setSalary(employeeDetails.getSalary());
		
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		logger.info("deleting the employee with employee number: {}",employeeId);
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for id:: "+employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@DeleteMapping("/deleteEmployee")
	public Map<String, Boolean> deleteAllEmployee()
			throws ResourceNotFoundException {
		logger.info("deleting all the employees");
		employeeRepository.deleteAll();
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
