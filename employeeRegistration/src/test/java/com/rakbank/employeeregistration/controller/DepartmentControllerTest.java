package com.rakbank.employeeregistration.controller;

import com.rakbank.employeeregistration.entity.Department;
import com.rakbank.employeeregistration.repository.DepartmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentRepository departmentRepository;

    @Test
    public void findAll_Departments() throws Exception {
        Department departmentFirst = new Department();
        departmentFirst.setCode("AD");
        departmentFirst.setDescription("Administration");
        Department departmentSecond = new Department();
        departmentSecond.setCode("IT");
        departmentSecond.setDescription("Information Technology");

        when(departmentRepository.findAll()).thenReturn(Arrays.asList(departmentFirst, departmentSecond));

        mockMvc.perform(get("/api/v1/departments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
