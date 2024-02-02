package com.net.java.department.DepartmentService.service;

import java.util.List;

import com.net.java.department.DepartmentService.dto.DepartmentDto;


public interface DepartmentService {

	public DepartmentDto saveDepartmentDetails(DepartmentDto entity);
	
	public List<DepartmentDto> getAllDepartmentDetails();
	
	public DepartmentDto getDepartmentsById(long id);
	
}
