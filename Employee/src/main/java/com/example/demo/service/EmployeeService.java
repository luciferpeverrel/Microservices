package com.example.demo.service;

import com.example.demo.model.Cars;
import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {


    Employee saveEmployees(Employee employee);

    // Read operation
    List<Employee> getEmployees();
}
