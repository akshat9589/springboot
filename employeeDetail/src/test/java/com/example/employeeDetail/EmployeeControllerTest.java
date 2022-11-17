package com.example.employeeDetail;

import com.example.employeeDetail.controller.EmployeeController;
import com.example.employeeDetail.dao.EmployeeRepository;
import com.example.employeeDetail.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("ALL")
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
    private MockMvc mockMvc;
    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();

    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeController employeeController;

    Employee employee=new Employee(1,"Akshat","80000","9589690031");
    Employee employee1=new Employee(2,"Bittu","5000","85852325");
    Employee employee2=new Employee(3,"aksh","4560","4569745600");

     @Before
    public  void setUp(){
         MockitoAnnotations.initMocks(this);
         this.mockMvc= MockMvcBuilders.standaloneSetup(employeeRepository).build();
     }
     @Test
    public void getAllEmployee() throws Exception{
         List<Employee> employeeList=new ArrayList<>(Arrays.asList(employee,employee2,employee1));
         Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
         mockMvc.perform(MockMvcRequestBuilders
                 .get("/employee")
                 .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$",hasSize(3)))
                 .andExpect(jsonPath("$[2].name",is("aksh"))
                 );
     }


}
