package com.rakbank.employeeregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employee {
	@Id
	private long employeeNo;
	private String employeeName;
	private Date dateOfJoining;
	private String department;
	private long salary;
}
