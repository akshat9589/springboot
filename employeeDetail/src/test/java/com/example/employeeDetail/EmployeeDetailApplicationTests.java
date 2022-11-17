package com.example.employeeDetail;

import com.example.employeeDetail.dao.EmployeeRepository;
import com.example.employeeDetail.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class EmployeeDetailApplicationTests{
	@Autowired
	private EmployeeRepository employeeRepository;
	private Employee employee;
	@BeforeEach
	public void setUp(){
		employee=new Employee(1,"akshat","80555555","213314");

	}
	@AfterEach
	public void tearDown(){
		employeeRepository.deleteAll();
		employee=null;
	}

	@Test
	public void addEmployee(){
		employeeRepository.save(employee);
		Employee fetchEmployee=employeeRepository.findById(employee.getId()).get();
		assertEquals(1,fetchEmployee.getId());
	}
	@Test
	public void getAllEmployee(){
		Employee employee1=new Employee(1,"akshat","80000","8085152662");
		Employee employee2= new Employee(2,"bittu","15500","984563214");
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);

		List<Employee>employeeList= employeeRepository.findAll();
		assertEquals("akshat",employeeList.get(0).getEname());
	}

	@Test
	public void getEmployeeByIdTest() {
		Employee employee1 = new Employee(1,"Akshay","123","8085455550");

		Employee employee2= employeeRepository.save(employee1);
		Optional<Employee> optional =  employeeRepository.findById(employee2.getId());
		assertEquals(employee2.getId(), optional.get().getId());
		assertEquals(employee2.getEname(), optional.get().getEname());
	}

	@Test
	public void DeleteEmployeeById(){
		Employee employee1=new Employee(1,"aksh","20000","800000");
		employeeRepository.save(employee1);
		employeeRepository.deleteById(employee1.getId());
		Optional optional = employeeRepository.findById(employee.getId());
		assertEquals(Optional.empty(), optional);
	}



}