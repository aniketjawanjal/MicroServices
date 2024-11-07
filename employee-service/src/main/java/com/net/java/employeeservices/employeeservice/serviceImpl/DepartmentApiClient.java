package com.net.java.employeeservices.employeeservice.serviceImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.net.java.employeeservices.employeeservice.dto.DepartmentDto;
import com.net.java.employeeservices.employeeservice.dto.OrganizationDto;

@FeignClient(url = "http://localhost:8081",value ="DEPARTMENT-SERVICE")
public interface DepartmentApiClient {

	@GetMapping("/api/departments/get-department-code/{department-code}")
	DepartmentDto getDepartment(@PathVariable("department-code") String departmentdto);
	
	
}
