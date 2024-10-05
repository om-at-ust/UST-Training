package com.UST.ProjectInfo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
    private String projectName;
    private String projectDescription;
    private String projectManager;
    private String teamMembers;
    private String projectStatus;
    private String projectStartDate;

    private String projectEndDate;
    private double projectBudget;
    private String CompanyName;
    private Long ccCode;




}
