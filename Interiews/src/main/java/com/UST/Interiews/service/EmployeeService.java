package com.UST.Interiews.service;

import com.UST.Interiews.entity.Employee;
import com.UST.Interiews.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired

    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByProjectId(Long id){
        return employeeRepository.findAllByProject_ProjectId(id);
    }
    public List<Employee> getFailedEmployeesByProjectId(Long id,String status){
        List<Employee> employees = employeeRepository.findAllByProject_ProjectId(id);
        List<Employee> filteredEmployees = employees.stream().filter(employee -> employee.getStatus().equalsIgnoreCase(status)).toList();
        return filteredEmployees;
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }
}
