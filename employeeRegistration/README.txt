The application is developed using Java 8, spring boot and spring MVC architecture.

DataBase integration is done by using Hiberante,JPA.

InMemory DB is used for storing data.

Rest based URL for accessing CRUD operation:

1.Create Employee: POST :http://localhost:8080/employeeRegistration/api/v1/employees

2.Get all employees:
GET: http://localhost:8080/employeeRegistration/api/v1/employees

3.Get employee by Employee number:(pass employee number as id)
GET: http://localhost:8080/employeeRegistration/api/v1/employees/id

4.Get employee by Employeename:(pass employee name)
GET: http://localhost:8080/employeeRegistration/api/v1/employee/name

5.Edit employee using employee number
PUT: http://localhost:8080/employeeRegistration/api/v1/employees/id

6.Delete employee using employee number
DELETE:
http://localhost:8080/employeeRegistration/api/v1/employees/id

7. Delete all employees
DELETE:
http://localhost:8080/employeeRegistration/api/v1/deleteEmployee
