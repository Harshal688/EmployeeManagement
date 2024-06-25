package com.project.EmployeeManagementSystem.service;

import java.util.List;

import com.project.EmployeeManagementSystem.model.Employee;

public interface EmployeeService {
	
	String createEmployee(Employee employee) ;
	List<Employee>  readEmployee();
	boolean deleteEmployee(Long id);
		
	

}
