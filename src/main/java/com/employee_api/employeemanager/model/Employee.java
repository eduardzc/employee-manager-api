package com.employee_api.employeemanager.model;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Schema(description = "Employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long id;
	
	@Column(name="name")
	@NotBlank(message="Name is required")
	@Schema(description = "employees's name", example = "John Doe")
	private String name;
	
	@Column(name="email")
	@NotBlank(message="Email is required")
	@Email(message="Email adress is not valid")
	@Schema(description = "employees's email", example = "johndoe@mail.com")
	private String email;
	
	@Column(name="position")
	@NotBlank(message="Every employee must have a position")
	@Schema(description = "employees's job position", example = "Scrum Master")
	private String position;

}
