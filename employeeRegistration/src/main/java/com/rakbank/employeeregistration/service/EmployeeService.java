package com.rakbank.employeeregistration.service;

import com.rakbank.employeeregistration.entity.Employee;
import com.rakbank.employeeregistration.exception.CustomExceptionEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public  List<Employee> getAllEmployees() throws CustomExceptionEmployee;
    public Employee getEmployeeById(Long employeeNo) throws CustomExceptionEmployee;
    public List<Employee> getEmployeesByName(String employeeName) throws CustomExceptionEmployee;
    public Employee createEmployee(Employee employee) throws CustomExceptionEmployee;
    public Employee updateEmployee(Long employeeNo, Employee employeeDetails) throws CustomExceptionEmployee;
    public boolean deleteEmployeeById(Long employeeNo) throws CustomExceptionEmployee;
    public boolean deleteAllEmployees() throws CustomExceptionEmployee;
}
