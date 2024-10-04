package com.UST.EmployeeInfo.service;

import com.UST.EmployeeInfo.client.FullResponse;
import com.UST.EmployeeInfo.entity.Employee;
import com.UST.EmployeeInfo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }
    public FullResponse getEmployeeByProjectCode(Long ccCode) {
        return employeeRepository.findByccCode(ccCode);
    }
}
