package com.UST.ProjectInfo.repository;

import com.UST.ProjectInfo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByCcCode(Long employeeId);
}
