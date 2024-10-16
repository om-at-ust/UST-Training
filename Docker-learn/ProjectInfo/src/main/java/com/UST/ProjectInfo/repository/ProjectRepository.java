package com.UST.ProjectInfo.repository;

import com.UST.ProjectInfo.Entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, Long> {
    List<Project> findAllByCcCode(Long employeeId);
}
