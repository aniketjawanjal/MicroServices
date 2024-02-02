package com.net.java.employeeservices.employeeservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class EmployeeDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Email(message = "Email is not valid.")
	@NotEmpty(message = "Email Should Not Be Null or Empty.")
	private String email;
	
	@Column(name = "first_name")
	@NotEmpty(message = "First Name Should Not Be Empty.")
	private String firstName;
	
	@NotEmpty(message = "Last Name Should Not Be Empty.")
	@Column(name = "last_name")
	private String lastName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

}
