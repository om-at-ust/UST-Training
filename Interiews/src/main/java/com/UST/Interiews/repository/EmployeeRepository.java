package com.UST.Interiews.repository;

import com.UST.Interiews.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
//    List<Employee> findAllByProjectId(Long projectId);
List<Employee> findAllByProject_ProjectId(Long projectId);
}
