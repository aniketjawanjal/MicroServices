package com.net.java.employeeservices.employeeservice.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.net.java.employeeservices.employeeservice.dto.EmployeeDto;

@Repository
public interface EmployeeService {

	public EmployeeDto saveEmployeeDetails(EmployeeDto dto);
	
	public EmployeeDto getEmployeeDetailsById(Long id);
	
	public List<EmployeeDto> getAllEmployeeDetails();
}
