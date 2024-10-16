package com.UST.EmployeeInfo.service;

import com.UST.EmployeeInfo.client.FullResponse;
import com.UST.EmployeeInfo.client.Project;
import com.UST.EmployeeInfo.entity.Employee;
import com.UST.EmployeeInfo.fegin.ProjectClient;
import com.UST.EmployeeInfo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectClient.AddressClient addressClient;

    public Employee addEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    public FullResponse getEmployeeByProjectCode(Long ccCode) {
        Employee employee = employeeRepository.findByccCode(ccCode);
        List<Project> projects = addressClient.getProjectByCode(ccCode);
        FullResponse fullResponse = new FullResponse();
        fullResponse.setCcCode(employee.getCcCode());
        fullResponse.setName(employee.getName());
        fullResponse.setDepartment(employee.getDepartment());
        fullResponse.setDesignation(employee.getDesignation());
        fullResponse.setSkills(employee.getSkills());
        fullResponse.setPhone(employee.getPhone());
        fullResponse.setAddress(employee.getAddress());
        fullResponse.setCity(employee.getCity());
        fullResponse.setState(employee.getState());
        fullResponse.setExp(employee.getExp());
        fullResponse.setEmail(employee.getEmail());
        fullResponse.setProjects(projects);

return fullResponse;
    }
}
