package com.example.hw2_9_stream;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMaxSalaryByDepartment(int department) {
        return employeeService.getAllEmployee()
                .stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public Employee getMinSalaryByDepartment(int department) {
        return employeeService.getAllEmployee()
                .stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public List<Employee> getAllEmployeeInDepartment(int department) {
        return employeeService.getAllEmployee()
                .stream()
                .filter(x -> x.getDepartment() == department)
                .toList();
    }

    public Map<Integer, List<Employee>> getAllByDepartment() {
        return employeeService.getAllEmployee()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
