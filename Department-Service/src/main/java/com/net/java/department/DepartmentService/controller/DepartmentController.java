package com.net.java.department.DepartmentService.controller;

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

import com.net.java.department.DepartmentService.dto.DepartmentDto;
import com.net.java.department.DepartmentService.entity.DepartmentEntity;
import com.net.java.department.DepartmentService.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	DepartmentService service;

	@GetMapping
	public String departmentService() {
		return "Department Service..";
	}

	@PostMapping("/save")
	public ResponseEntity<DepartmentDto> saveDepartmentDetail(@Valid @RequestBody DepartmentDto entity) {
		DepartmentDto departmentDetails = service.saveDepartmentDetails(entity);

		return new ResponseEntity<DepartmentDto>(departmentDetails, HttpStatus.CREATED);
	}

	@GetMapping("/get-departments")
	public ResponseEntity<List<DepartmentDto>> getAllDepartmentsDetails() {
		List<DepartmentDto> departmentDetails = service.getAllDepartmentDetails();

		return new ResponseEntity<List<DepartmentDto>>(departmentDetails, HttpStatus.OK);
	}

	@GetMapping("/get-department-id/{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable long id) {
		DepartmentDto departmentsById = service.getDepartmentsById(id);
		return new ResponseEntity<DepartmentDto>(departmentsById, HttpStatus.OK);
	}

	@GetMapping("/get-department-code/{departmentCode}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String departmentCode) {
		return new ResponseEntity<DepartmentDto>(service.getDepartmentsCode(departmentCode), HttpStatus.OK);
	}

}
