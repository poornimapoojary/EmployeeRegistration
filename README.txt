Project Document:
Spring boot REST API Application is for Employee Registration - CRUD Operations.

ech stack : Java 1.8, Spring boot,Spring boot data JPA, Hibernate, In Memory DB.


Front End:

# Angular8Springboot
This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.0.1.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build
Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

Rest end point : 'http://localhost:8080/springboot-crud-rest/api/v1/employees';

Back End:
Rest based URL for accessing CRUD operation:

1.Create Employee: POST :http://localhost:8080/employeeRegistration/api/v1/employees

2.Get all employees:
GET: http://localhost:8080/employeeRegistration/api/v1/employees

3.Get employee by Employee number:(pass employee number as id)
GET: http://localhost:8080/employeeRegistration/api/v1/employees/id

4.Get employee by Employee name:(pass employee name)
GET: http://localhost:8080/employeeRegistration/api/v1/employee/name

5.Edit employee using employee number
PUT: http://localhost:8080/employeeRegistration/api/v1/employees/id

6.Delete employee using employee number
DELETE:
http://localhost:8080/employeeRegistration/api/v1/employees/id

7. Delete all employees
DELETE:
http://localhost:8080/employeeRegistration/api/v1/deleteEmployee
