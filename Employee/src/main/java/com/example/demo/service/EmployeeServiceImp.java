package com.example.demo.service;


import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp extends EmployeeServiceImp {

    @Autowired
    private EmployeeRepository employeeRepository;


    // Save operation
    @Override
    public Employee saveEmployee(Employee employee) {
        return EmployeeRepository.saveEmployees();
    }


    @Override
    public Employee saveEmployees(Employee employee) {
        return null;
    }

    // Read operation
    @Override
    public List<Employee> getEmployee() {
        return (List<Employee>) EmployeeRepository.findAll();
    }
}
