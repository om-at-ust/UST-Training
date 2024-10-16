package com.UST.ProjectInfo.dto;

import jakarta.validation.constraints.*;


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

    public ProjectDto(String projectName, String projectDescription, String projectManager, String teamMembers, String projectStatus, String projectStartDate, String projectEndDate, double projectBudget, String companyName, Long ccCode) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectManager = projectManager;
        this.teamMembers = teamMembers;
        this.projectStatus = projectStatus;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectBudget = projectBudget;
        CompanyName = companyName;
        this.ccCode = ccCode;
    }

    public ProjectDto() {
    }

    public @NotNull(message = "Project name cannot be null") String getProjectName() {
        return projectName;
    }

    public void setProjectName(@NotNull(message = "Project name cannot be null") String projectName) {
        this.projectName = projectName;
    }

    public @NotNull(message = "Project name cannot be null") String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(@NotNull(message = "Project name cannot be null") String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public @NotNull(message = "Project name cannot be null") String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(@NotNull(message = "Project name cannot be null") String projectManager) {
        this.projectManager = projectManager;
    }

    public @Min(value = 2, message = "Team members must be at least 2") @Max(value = 200, message = "Team members cannot exceed 200") String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(@Min(value = 2, message = "Team members must be at least 2") @Max(value = 200, message = "Team members cannot exceed 200") String teamMembers) {
        this.teamMembers = teamMembers;
    }

    public @Pattern(regexp = "^(InProgress|Completed)$", message = "Invalid project status") String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(@Pattern(regexp = "^(InProgress|Completed)$", message = "Invalid project status") String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(String projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public double getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(double projectBudget) {
        this.projectBudget = projectBudget;
    }

    public @NotBlank(message = "Company name cannot be blank") String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(@NotBlank(message = "Company name cannot be blank") String companyName) {
        CompanyName = companyName;
    }

    public Long getCcCode() {
        return ccCode;
    }

    public void setCcCode(Long ccCode) {
        this.ccCode = ccCode;
    }
}
