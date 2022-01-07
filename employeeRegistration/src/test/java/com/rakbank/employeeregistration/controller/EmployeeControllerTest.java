//package com.rakbank.employeeregistration.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.rakbank.employeeregistration.entity.Employee;
//import com.rakbank.employeeregistration.repository.DepartmentRepository;
//import com.rakbank.employeeregistration.repository.EmployeeRepository;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@Ignore
//@RunWith(SpringRunner.class)
//@WebMvcTest(EmployeeController.class)
//public class EmployeeControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private EmployeeRepository employeeRepository;
//    @MockBean
//    private DepartmentRepository departmentRepository;
//    @Test
//    public void getAllEmployees() throws Exception {
//        Employee employee = new Employee();
//        employee.setEmployeeNo(100);
//        employee.setEmployeeName("test");
//
//        List<Employee> allEmployee = Arrays.asList(employee);
//
//        given(employeeRepository.findAll())
//                .willReturn(allEmployee);
//
//        mockMvc.perform(get("/api/v1/employees")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void getEmployeeById() throws Exception {
//        Employee employee = new Employee();
//        employee.setEmployeeNo(100);
//        employee.setEmployeeName("test");
//
//        given(employeeRepository.findById(anyLong())).willReturn(Optional.of(employee));
//
//        mockMvc.perform(get("/api/v1/employees/100" )
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("employeeName", is(employee.getEmployeeName())));
//    }
//
//    @Test
//    public void getEmployeeByName() throws Exception {
//        Employee employee = new Employee();
//        employee.setEmployeeNo(100);
//        employee.setEmployeeName("test");
//        List<Employee> allEmployee = Arrays.asList(employee);
//        given(employeeRepository.findByEmployeeName(anyString())).willReturn(allEmployee);
//
//        mockMvc.perform(get("/api/v1/employee/test" )
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void createEmployee() throws Exception {
//        Employee employee = new Employee();
//        employee.setEmployeeNo(100);
//        employee.setEmployeeName("test");
//
//        given(employeeRepository.save(employee)).willReturn(employee);
//
//        mockMvc.perform(post("/api/v1/employees")
//                        .contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    public void updateEmployee() throws Exception {
//        Employee employee = new Employee();
//        employee.setEmployeeNo(100);
//        employee.setEmployeeName("test");
//
//        given(employeeRepository.findById(anyLong())).willReturn(Optional.of(employee));
//        ObjectMapper mapper = new ObjectMapper();
//
//        mockMvc.perform(put("/api/v1/employees/" + employee.getEmployeeNo())
//                        .content(mapper.writeValueAsString(employee))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//    }
//
//    @Test
//    public void deleteEmployee() throws Exception {
//        Employee employee = new Employee();
//        employee.setEmployeeNo(100);
//        employee.setEmployeeName("test");
//
//        given(employeeRepository.findById(anyLong())).willReturn(Optional.of(employee));
//        mockMvc.perform(delete("/api/v1/employees/" + employee.getEmployeeNo())
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void deleteAllEmployee() throws Exception {
//        mockMvc.perform(delete("/api/v1/deleteEmployee")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//}