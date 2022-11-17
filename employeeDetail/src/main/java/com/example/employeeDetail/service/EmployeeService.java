package com.example.employeeDetail.service;

import com.example.employeeDetail.dao.EmployeeRepository;
import com.example.employeeDetail.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> createEmployees(List <Employee> employee){
        return employeeRepository.saveAll(employee);
    }
    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Employee employee){
        Employee oldemp=null;
        Optional<Employee> oldEmployee=employeeRepository.findById(employee.getId());
        if(oldEmployee.isPresent()){
          oldemp=oldEmployee.get();
            oldemp.setEname(employee.getEname());
            oldemp.setEsalary(employee.getEsalary());
            oldemp.setMobile(employee.getMobile());
            employeeRepository.save(oldemp);
        }else{
            return new Employee();

        }
        return  oldemp;
    }

    public String deleteUserById(int id){
        employeeRepository.deleteById(id);
        return "User Deleted ";
    }

}
