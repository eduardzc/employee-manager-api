package com.employee_api.employeemanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee_api.employeemanager.exception.ResourceNotFoundException;
import com.employee_api.employeemanager.model.Employee;
import com.employee_api.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository repository;
	
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee findById(Long id) {
		return repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("id:" + id + " - Employee not found"));
	}

	@Override
	public Employee create(Employee employee) {
		return repository.save(employee);
	}
	
	@Override
	public Employee update(Long id, Employee employee) {
		Employee existingEmployee = findById(id);
		
		if(employee.getName() != null) {
			existingEmployee.setName(employee.getName());
		}
		if(employee.getEmail() != null) {
			existingEmployee.setEmail(employee.getEmail());
		}
		if(employee.getPosition() != null) {
			existingEmployee.setPosition(employee.getPosition());
		}
		
		return repository.save(existingEmployee);
	}

	@Override
	public void delete(Long id) {
		Employee existingEmployee = findById(id);
		repository.delete(existingEmployee);
	}

}
