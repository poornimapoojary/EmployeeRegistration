package com.rakbank.employeeregistration.controller;

import com.rakbank.employeeregistration.exception.CustomExceptionEmployee;
import com.rakbank.employeeregistration.entity.Employee;
import com.rakbank.employeeregistration.repository.EmployeeRepository;
import com.rakbank.employeeregistration.service.EmployeeService;
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
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepository;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() throws CustomExceptionEmployee {
		logger.info("Listing all Employee details");
		return employeeService.getAllEmployees();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeNo)
			throws CustomExceptionEmployee {
		logger.info("Getting the employee by employee number: ",employeeNo);
		Employee employee = employeeService.getEmployeeById(employeeNo);
		return ResponseEntity.ok().body(employee);
	}
	
	@GetMapping("/employee/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable(value = "name") String employeeName)
			throws CustomExceptionEmployee {
		logger.info("Getting the employee by employee name: ",employeeName);
		List<Employee> employeeList = employeeService.getEmployeesByName(employeeName);
		return ResponseEntity.ok().body(employeeList);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) throws CustomExceptionEmployee {
		logger.info("Adding new Employee: {}",employee);
		return employeeService.createEmployee(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeNo,
			@Valid @RequestBody Employee employeeDetails) throws CustomExceptionEmployee {
		logger.info("Updating the Employee with Employee Number: {}",employeeNo);
		final Employee updatedEmployee = employeeService.updateEmployee(employeeNo, employeeDetails);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws CustomExceptionEmployee {
		logger.info("deleting the employee with employee number: {}",employeeId);
		boolean isDeleted = employeeService.deleteEmployeeById(employeeId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", isDeleted);
		return response;
	}
	@DeleteMapping("/deleteEmployee")
	public Map<String, Boolean> deleteAllEmployee() throws CustomExceptionEmployee {
		logger.info("deleting all the employees");
		boolean isDeleted = employeeService.deleteAllEmployees();
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", isDeleted);
		return response;
	}
}
