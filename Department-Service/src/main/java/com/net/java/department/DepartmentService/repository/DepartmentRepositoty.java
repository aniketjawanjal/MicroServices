package com.net.java.department.DepartmentService.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.net.java.department.DepartmentService.entity.DepartmentEntity;

public interface DepartmentRepositoty extends JpaRepository<DepartmentEntity, Long>{

	DepartmentEntity findBydepartmentcode(String departmentname);
	
}
