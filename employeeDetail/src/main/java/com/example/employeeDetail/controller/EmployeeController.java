package com.example.employeeDetail.controller;


import com.example.employeeDetail.entity.Employee;
import com.example.employeeDetail.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

   @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
     return employeeService.createEmployee(employee);

    }
    @PostMapping("/addEmployees")
    public List<Employee> addUser(@RequestBody List<Employee> employees){
        return employeeService.createEmployees(employees);
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getEmployees")
    public List <Employee> getAllEmploee(){
        return employeeService.getEmployees();
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/employeeDelete/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteUserById(id);
    }
}
