package com.rakbank.employeeregistration;

import com.rakbank.employeeregistration.entity.Department;
import com.rakbank.employeeregistration.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EmployeeRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistrationApplication.class, args);
	}

	@Bean
	CommandLineRunner init (DepartmentRepository departmentRepository){
		return args -> {
			// Adding department data
			List<Department> departmentList = Arrays.asList(new Department("AD","Administration"),
					new Department("IT","Information technology"),
					new Department("HD","Help Desk"),
					new Department("HR","Human Resource"),
					new Department("OP","Operation"));
			departmentList.forEach(name -> departmentRepository.saveAll(departmentList));
		};
	}
}
