package com.example.demo.controller;

import com.example.demo.model.Cars;
import com.example.demo.model.Employee;
import com.example.demo.service.CarsService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //save operation
    @PostMapping("/add")
    public Employee saveEmployees(@Valid @RequestBody Employee employee){
        return  employeeService.saveEmployees(employee);

    }

    //read operation
    @GetMapping("/get")
    public List<Employee> getEmployees(){
        return  employeeService.getEmployees();
    }

}
