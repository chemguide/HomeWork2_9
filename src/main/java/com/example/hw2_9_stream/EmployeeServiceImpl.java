package com.example.hw2_9_stream;

import com.example.hw2_9_stream.Exceptions.ArrayIsFullException;
import com.example.hw2_9_stream.Exceptions.EmployeeAlreadyAddedException;
import com.example.hw2_9_stream.Exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    Map<String, Employee> employees = new HashMap<>();

    private final int capacity = 10;

    public void addEmployee(String name, String surname, int department, double salary) {
        String key = name + surname + department + salary;
        if (employees.size() >= capacity) {
            throw new ArrayIsFullException();
        }
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(key, new Employee(name, surname, department, salary));
    }

    public void removeEmployee(String name, String surname, int department, double salary) {
        String key = name + surname + department + salary;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
    }

    public void findEmployee(String name, String surname, int department, double salary) {
        String key = name + surname + department + salary;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
    }

    public List<Employee> getAllEmployee() {
        return  new ArrayList<>(employees.values());
    }
}
