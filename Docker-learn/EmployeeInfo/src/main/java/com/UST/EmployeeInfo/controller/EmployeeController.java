package com.UST.EmployeeInfo.controller;

import com.UST.EmployeeInfo.client.FullResponse;
import com.UST.EmployeeInfo.entity.Employee;
import com.UST.EmployeeInfo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/withProjects/{ccCode}")
    public ResponseEntity<FullResponse> getEmployeeByProjectCode(@PathVariable Long ccCode){
        return new ResponseEntity<>(employeeService.getEmployeeByProjectCode(ccCode),HttpStatus.OK);
    }

}
