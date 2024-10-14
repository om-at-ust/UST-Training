package com.UST.Interiews.controller;

import com.UST.Interiews.dto.EmployeeDTO;
import com.UST.Interiews.dto.ProjectDTO;
import com.UST.Interiews.entity.Employee;
import com.UST.Interiews.entity.Project;
import com.UST.Interiews.service.EmployeeService;
import com.UST.Interiews.service.InterviewService;
import com.UST.Interiews.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OneForAllController {
    @Autowired
    private EmployeeService  employeeService;
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private ProjectService projectService;

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/allEmployees/{projectId}")
    public List<Employee>  getAllEmployeesByProjectId(@PathVariable Long projectId) {
        return employeeService.getEmployeesByProjectId(projectId);
    }

    @GetMapping("/employees/fail/{projectId}/{status}")
    public List<Employee>  getFailedEmployeesByProjectId(@PathVariable Long projectId,@PathVariable String status) {
        return employeeService.getFailedEmployeesByProjectId(projectId,status);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        // Find the project by projectId
        Project project = projectService.findByProjectId(employeeDTO.getProjectId());


        // Create a new Employee entity
        Employee employee = new Employee();
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setProject(project); // Link the employee to the project
        employee.setStatus(employeeDTO.getStatus());

        // Save the employee to the repository
        employeeService.saveEmployee(employee);

        return ResponseEntity.ok("Employee added successfully to the project");
    }

    @PostMapping("/addProject")
    public ResponseEntity<String> addProject(@RequestBody ProjectDTO projectDTO) {
        // Create a new Project entity
        Project project = new Project();
        project.setProjectName(projectDTO.getProjectName());
        project.setProjectDescription(projectDTO.getProjectDescription());

        // Save the project to the repository
        projectService.saveProject(project);

        return ResponseEntity.ok("Project added successfully");
    }

}
