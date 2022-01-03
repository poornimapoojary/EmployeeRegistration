import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { DepartmentService } from '../department.service';
import { Department } from '../department';
import { Observable } from "rxjs";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  title = 'Employee Registration Form';
  departments: Observable<Department[]>;
  empForm: any;
  employee: Employee = new Employee();
  submitted = false;

  constructor(private employeeService: EmployeeService, private departmentService: DepartmentService,
    private router: Router) { }

  ngOnInit():void {
    this.empForm = new FormGroup({
      "employeeNo": new FormControl(null,[Validators.required,Validators.pattern('[0-9]+')]),
      "employeeName": new FormControl(null,Validators.required),
      "dateOfJoining": new FormControl(null,Validators.required),
      "department": new FormControl(null,Validators.required),
      "salary": new FormControl(null,[Validators.required,Validators.pattern('[0-9]+')])
      
    });
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save() {
    this.employeeService
    .createEmployee(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Employee();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  onClear(){
    this.submitted = false;
    this.newEmployee();
  }
  get employeeNo(){
    return this.empForm.get('employeeNo');
  }
  get employeeName(){
    return this.empForm.get('employeeName');
  }
  get dateOfJoining(){
    return this.empForm.get('dateOfJoining');
  }
  get department(){
    return this.empForm.get('department');
  }
  get salary(){
    return this.empForm.get('salary');
  }

}
