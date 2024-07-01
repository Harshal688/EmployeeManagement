package com.project.EmployeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.project.EmployeeManagementSystem.entity.EmployeeEntity;
import com.project.EmployeeManagementSystem.model.Employee;

@Service
@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String createEmployee(Employee employee) {
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		
		employeeRepository.save(employeeEntity);
		
		return "Employees created successfully";

	}  

	@Override
	public List<Employee> readEmployee() {
		
		List<EmployeeEntity>  employeeslist = employeeRepository.findAll();
		List<Employee> emps = new ArrayList<>();


		for (EmployeeEntity employeeEntity : employeeslist) {
			
			Employee emp = new Employee();
			emp.setId(employeeEntity.getId());
			emp.setEmail(employeeEntity.getEmail());
			emp.setName(employeeEntity.getName());
			emp.setPhno(employeeEntity.getPhno());
			
			emps.add(emp);

		}
		
		return emps;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		
		EmployeeEntity emp = employeeRepository.findById(id).get();
		employeeRepository.delete(emp);
		return true;
		
	}

	@Override
	public String updateEmployee(Long id, Employee employee) {
		
		EmployeeEntity empp = employeeRepository.findById(id).get();
		empp.setEmail(employee.getEmail());
		empp.setName(employee.getName());
		empp.setPhno(employee.getPhno());

		employeeRepository.save(empp);
		return "Updated Sucessfully";
		
	}

	@Override
	public Employee readEmployeebyid(Long id) {
		EmployeeEntity ent = employeeRepository.findById(id).get();
		Employee emp = new Employee();
		BeanUtils.copyProperties(ent, emp);
		
		return emp;
	}

	
	

	
	
	

}
