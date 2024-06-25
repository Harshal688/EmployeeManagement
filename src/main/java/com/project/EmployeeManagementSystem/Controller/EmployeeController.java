package com.project.EmployeeManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EmployeeManagementSystem.model.Employee;
import com.project.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping
	public List<Employee> fetchAllEmployees() {
		
		return employeeService.readEmployee();
		
	}
	
	@PostMapping
	public String createEmployee(@RequestBody Employee employee) {
		
		return employeeService.createEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteEmployee(@PathVariable Long id) {
		if (employeeService.deleteEmployee(id)) {
			return true;
		}
		return false;
	}

}
