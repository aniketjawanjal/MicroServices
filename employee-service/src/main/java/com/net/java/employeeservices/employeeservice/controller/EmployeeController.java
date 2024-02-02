package com.net.java.employeeservices.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.java.employeeservices.employeeservice.dto.EmployeeDto;
import com.net.java.employeeservices.employeeservice.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping
	public String EmployeeDemo() {
		return "Employee Service";
	}

	@PostMapping("save")
	public ResponseEntity<EmployeeDto> saveEmployeeDetails(@Valid @RequestBody EmployeeDto dto) {
		return new ResponseEntity<EmployeeDto>(service.saveEmployeeDetails(dto), HttpStatus.CREATED);
	}

	@GetMapping("get-all-employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployeeDetails() {
		return new ResponseEntity<List<EmployeeDto>>(service.getAllEmployeeDetails(), HttpStatus.OK);
	}

	@GetMapping("get-employee/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) {
		return new ResponseEntity<EmployeeDto>(service.getEmployeeDetailsById(id), HttpStatus.OK);
	}
}
