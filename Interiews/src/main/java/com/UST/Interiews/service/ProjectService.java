package com.UST.Interiews.service;

import com.UST.Interiews.entity.Project;
import com.UST.Interiews.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project findByProjectId(Long id){
        return projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Project not found with id: " + id));
    }
    public void saveProject(Project project){
        projectRepository.save(project);
    }

}
