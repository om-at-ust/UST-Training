package com.UST.ProjectInfo.controller;

import com.UST.ProjectInfo.Entity.Project;
import com.UST.ProjectInfo.dto.ProjectDto;
import com.UST.ProjectInfo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/addProject")
    public ResponseEntity<Project> addProject(@RequestBody ProjectDto projectDto){
        return new ResponseEntity<>(projectService.addProject(projectDto), HttpStatus.OK);
    }

    @GetMapping("/project/{ccode}")
    public ResponseEntity<?> getProjectByCode(@PathVariable Long ccode){
        return new ResponseEntity<>(projectService.getProjectByCode(ccode),HttpStatus.OK);
    }

}
