package com.employee_api.employeemanager.controller;

import java.util.List;

import com.employee_api.employeemanager.exception.CustomErrorResponse;
import com.employee_api.employeemanager.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employees", description = "Operations related to employees")
public class EmployeeController {
	
	private EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping
	@Operation(summary = "Get all employees", description = "Return a list of all employees")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "List of employees returned",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = Employee.class)
					)
			)
	})
	public List<Employee> getAllEmployees(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Get an employee by ID", description = "Returns a single employee by their ID")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200",
							description = "Employee found",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Employee.class)
							)
					),
					@ApiResponse(
							responseCode = "404",
							description = "Employee not found",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = CustomErrorResponse.class)
							)
					)
			}
	)
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@Operation(summary = "Create a new employee", description = "Adds a new employee to the database")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "201",
					description = "Employee created successfully",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = Employee.class)
					)
			),
			@ApiResponse(responseCode = "400",
					description = "Invalid employee data",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CustomErrorResponse.class)
					)
			)
	})
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		return ResponseEntity.ok(service.create(employee));
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Update an existing employee", description = "Updates the employee identified by the given ID")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Employee updated successfully",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = Employee.class)
					)
			),
			@ApiResponse(responseCode = "400",
					description = "Invalid employee data",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CustomErrorResponse.class)
					)
			),
			@ApiResponse(responseCode = "404",
					description = "Employee not found",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CustomErrorResponse.class)
					)
			)
	})
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody Employee employee){
		return ResponseEntity.ok(service.update(id, employee));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete an employee by ID", description = "Deletes a single employee by their ID")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "204",
							description = "Employee deleted",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Employee.class)
							)
					),
					@ApiResponse(
							responseCode = "404",
							description = "Employee not found",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = CustomErrorResponse.class)
							)
					)
			}
	)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
