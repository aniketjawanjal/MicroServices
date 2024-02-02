package com.net.java.employeeservices.employeeservice.Repositoty;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.net.java.employeeservices.employeeservice.entity.EmployeeEntity;

public interface EmployeeRepositoty extends JpaRepository<EmployeeEntity, Long>{

	Optional<String> findByEmail(String email);
}
