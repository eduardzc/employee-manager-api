package com.employee_api.employeemanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_api.employeemanager.model.Employee;
import com.employee_api.employeemanager.service.EmployeeServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeServiceImpl service;
	
	public EmployeeController(EmployeeServiceImpl service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		return ResponseEntity.ok(service.create(employee));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody Employee employee){
		return ResponseEntity.ok(service.update(id, employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
