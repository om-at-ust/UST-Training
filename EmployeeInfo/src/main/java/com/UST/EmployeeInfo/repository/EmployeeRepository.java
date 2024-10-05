package com.UST.EmployeeInfo.repository;

import com.UST.EmployeeInfo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
Employee findByccCode(Long ccCode);
}
