package com.UST.Interiews.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;
    private String projectName;
    private String projectDescription;
    @OneToMany(mappedBy = "project")  // This refers to the "project" field in Employee
    private List<Employee> employees;  //
}
