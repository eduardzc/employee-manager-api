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

@Entity
@Table(name="employees")
@Schema(description = "Employees")
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
	
	public Employee() {
	}

	public Employee(Long id, @NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Email is required") @Email(message = "Email adress is not valid") String email,
			@NotBlank(message = "Every employee must have a position") String position) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", position=" + position + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(position, other.position);
	}

}
