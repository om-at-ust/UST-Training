package com.UST.EmployeeInfo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@Entity
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Long ccCode;
    private String name;
    private String department;
    private String designation;
    private String salary;
    private List<String> skills;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int exp;
    private String doj;
    private String email;

}
