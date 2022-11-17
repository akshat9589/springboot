package com.example.employeeDetail.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    public void Employee(int id,String name,String salary,String mobile){
        this.ename=name;
        this.id=id;
        this.esalary=salary;
        this.mobile=mobile;
    }
    @Id
    @GeneratedValue
    private int id;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String ename;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsalary() {
        return esalary;
    }

    public void setEsalary(String esalary) {
        this.esalary = esalary;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String esalary;
    private String mobile;
}
