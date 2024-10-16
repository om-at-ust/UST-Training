package com.UST.EmployeeInfo.repository;

import com.UST.EmployeeInfo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {
Employee findByccCode(Long ccCode);
}
