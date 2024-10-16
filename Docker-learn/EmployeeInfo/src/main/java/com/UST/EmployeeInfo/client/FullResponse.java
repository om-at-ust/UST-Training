package com.UST.EmployeeInfo.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullResponse {
    private Long ccCode;
    private String name;
    private String department;
    private String designation;
    private String email;
    private String phone;
    private String city;
    private String state;
    private String doj;
    private int exp;
    private String address;
    private List<String> skills;
    private List<Project> projects;
}
