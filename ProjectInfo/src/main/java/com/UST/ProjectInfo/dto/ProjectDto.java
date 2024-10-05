package com.UST.ProjectInfo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {


    @NotNull(message="Project name cannot be null")
    private String projectName;
    @NotNull(message="Project name cannot be null")
    private String projectDescription;
    @NotNull(message="Project name cannot be null")
    private String projectManager;
    @Min(value=2,message="Team members must be at least 2")
    @Max(value=200,message="Team members cannot exceed 200")
    private String teamMembers;
    @Pattern(regexp = "^(InProgress|Completed)$",message="Invalid project status")
    private String projectStatus;
    private String projectStartDate;
    private String projectEndDate;
    private double projectBudget;
    @NotBlank(message = "Company name cannot be blank")
    private String CompanyName;
    private Long ccCode;

}
