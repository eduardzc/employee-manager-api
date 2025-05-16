package com.employee_api.employeemanager.service;

import java.util.List;
import java.util.Optional;

import com.employee_api.employeemanager.model.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(Long id);
	
	public Employee create(Employee employee);
	
	public Employee update(Long id, Employee employee);
	
	public void delete(Long id);
	
}
