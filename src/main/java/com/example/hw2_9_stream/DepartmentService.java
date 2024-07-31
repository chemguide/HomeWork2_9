package com.example.hw2_9_stream;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getMaxSalaryByDepartment(int department);
    Employee getMinSalaryByDepartment(int department);
    List<Employee> getAllEmployeeInDepartment(int department);
    Map<Integer, List<Employee>> getAllByDepartment();
}
