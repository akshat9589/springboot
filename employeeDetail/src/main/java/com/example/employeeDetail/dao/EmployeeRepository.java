package com.example.employeeDetail.dao;

import com.example.employeeDetail.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {



}
