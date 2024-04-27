package com.net.java.employeeservices.employeeservice.serviceImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.net.java.employeeservices.employeeservice.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

	@GetMapping("api/department/{department-code}")
	DepartmentDto getDepartment(@PathVariable("department-code") String departmentdto);
}
