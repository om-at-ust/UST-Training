package com.UST.ProjectInfo.service;

import com.UST.ProjectInfo.Entity.Project;
import com.UST.ProjectInfo.dto.ProjectDto;
import com.UST.ProjectInfo.repository.ProjectRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(ProjectDto project) {
        Project project1 = new Project();
        project1.setProjectName(project.getProjectName());
        project1.setTeamMembers(project.getTeamMembers());
        project1.setProjectStatus(project.getProjectStatus());
        project1.setProjectStartDate(project.getProjectStartDate());
        project1.setProjectEndDate(project.getProjectEndDate());
        project1.setProjectBudget(project.getProjectBudget());
        project1.setCompanyName(project.getCompanyName());
        project1.setCcCode(project.getCcCode());
        return projectRepository.save(project1);

    }

    public List<Project> getProjectByCode(Long employeeId) {
        return projectRepository.findByCcCode(employeeId);
    }
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

}
