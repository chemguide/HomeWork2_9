package com.example.hw2_9_stream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "add")
    public Employee add(@RequestParam(value = "name") String name,
                        @RequestParam(value = "surname") String surname,
                        @RequestParam(value = "department") int department,
                        @RequestParam(value = "salary") double salary) {
        employeeService.addEmployee(name, surname, department, salary);
        return new Employee(name, surname, department, salary);
    }

    @RequestMapping(value = "remove")
    public Employee remove(@RequestParam(value = "name") String name,
                           @RequestParam(value = "surname") String surname,
                           @RequestParam(value = "department") int department,
                           @RequestParam(value = "salary") double salary) {
        employeeService.removeEmployee(name, surname, department, salary);
        return new Employee(name, surname, department, salary);
    }

    @RequestMapping(value = "find")
    public Employee find(@RequestParam(value = "name") String name,
                         @RequestParam(value = "surname") String surname,
                         @RequestParam(value = "department") int department,
                         @RequestParam(value = "salary") double salary) {
        employeeService.findEmployee(name, surname, department, salary);
        return new Employee(name, surname, department, salary);
    }

    @RequestMapping(value = "print")
    public List<Employee> print() {
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "max-salary")
    public Employee maxByDepartment(@RequestParam(value = "departmentId") int department) {
        return departmentService.getMaxSalaryByDepartment(department);
    }

    @RequestMapping(value = "min-salary")
    public Employee minByDepartment(@RequestParam(value = "departmentId") int department) {
        return departmentService.getMinSalaryByDepartment(department);
    }

    @RequestMapping(value = "all")
    public List<Employee> allInDepartment(@RequestParam(value = "departmentId") int department) {
        return departmentService.getAllEmployeeInDepartment(department);
    }

    @RequestMapping(value = "all")
    public Map<Integer, List<Employee>> allByDepartment() {
        return departmentService.getAllByDepartment();
    }
}
