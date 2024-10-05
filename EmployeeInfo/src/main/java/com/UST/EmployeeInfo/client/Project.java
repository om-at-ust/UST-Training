package com.UST.EmployeeInfo.client;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

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
