package com.employee_api.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_api.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
