package com.project.EmployeeManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.EmployeeManagementSystem.entity.EmployeeEntity;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

}
