package com.example.hw2_9_stream;

import java.util.List;

public interface EmployeeService {
    void addEmployee(String name, String surname, int department, double salary);
    void removeEmployee(String name, String surname, int department, double salary);
    void findEmployee(String name, String surname, int department, double salary);
    List<Employee> getAllEmployee();
    String checkSymbols(String string);
}
