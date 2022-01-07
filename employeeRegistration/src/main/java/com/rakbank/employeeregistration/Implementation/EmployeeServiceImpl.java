package com.rakbank.employeeregistration.Implementation;

import com.rakbank.employeeregistration.entity.Employee;
import com.rakbank.employeeregistration.exception.CustomExceptionEmployee;
import com.rakbank.employeeregistration.repository.EmployeeRepository;
import com.rakbank.employeeregistration.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() throws CustomExceptionEmployee {
        List<Employee> listAllEmployees = employeeRepository.findAll();
        if(listAllEmployees.isEmpty()){
            throw new CustomExceptionEmployee("No employees found");
        }
        return listAllEmployees;
    }

    @Override
    public Employee getEmployeeById(Long employeeNo) throws CustomExceptionEmployee {
        Employee employee = employeeRepository.findById(employeeNo)
                .orElseThrow(() -> new CustomExceptionEmployee("Employee not found with Employee number: "+employeeNo));
        return employee;
    }

    @Override
    public List<Employee> getEmployeesByName(String employeeName) throws CustomExceptionEmployee {
        List<Employee> employeeList = employeeRepository.findByEmployeeName(employeeName);
        if(employeeList.isEmpty()){
            throw new CustomExceptionEmployee("Employee not found with Employee name: "+employeeName);
        }
        return employeeList;
    }

    @Override
    public Employee createEmployee(Employee employee) throws CustomExceptionEmployee {
        Optional<Employee> employeeObj = employeeRepository.findById(employee.getEmployeeNo());
        if(employeeObj.isPresent()){
            throw  new CustomExceptionEmployee("Employee is already present");
        }
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee;
    }

    @Override
    public Employee updateEmployee(Long employeeNo, Employee employeeDetails) throws CustomExceptionEmployee {
        Employee updatedEmployee = employeeRepository.findById(employeeNo)
                .orElseThrow(() -> new CustomExceptionEmployee("Employee not present with Employee number: "+employeeNo));
        if(employeeDetails.getEmployeeNo()!=0){
            updatedEmployee.setEmployeeNo(employeeDetails.getEmployeeNo());
        }
        if(employeeDetails.getEmployeeName()!=null){
            updatedEmployee.setEmployeeName(employeeDetails.getEmployeeName());
        }
        if(employeeDetails.getDateOfJoining()!=null ){
            updatedEmployee.setDateOfJoining(employeeDetails.getDateOfJoining());
        }
        if(employeeDetails.getDepartment()!=null){
            updatedEmployee.setDepartment(employeeDetails.getDepartment());
        }
        if(employeeDetails.getSalary()!=0){
            updatedEmployee.setSalary(employeeDetails.getSalary());
        }
        return updatedEmployee;
    }

    @Override
    public boolean deleteEmployeeById(Long employeeNo) throws CustomExceptionEmployee {
        Employee isExistsEmployee = employeeRepository.findById(employeeNo)
                .orElseThrow(() -> new CustomExceptionEmployee("Employee not present with id: "+employeeNo));
        employeeRepository.delete(isExistsEmployee);
        return true;
    }

    @Override
    public boolean deleteAllEmployees() throws CustomExceptionEmployee {
        employeeRepository.deleteAll();
        return true;
    }
}
