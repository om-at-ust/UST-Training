package com.UST.Interiews.dto;


import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String empName;
    private Long projectId;  // To link the employee to a project

    @Pattern(regexp = "PASS|FAIL", message = "Status must be either 'PASS' or 'FAIL'")
    private String status;
}
