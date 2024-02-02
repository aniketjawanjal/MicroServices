package com.net.java.employeeservices.employeeservice.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.java.employeeservices.employeeservice.Repositoty.EmployeeRepositoty;
import com.net.java.employeeservices.employeeservice.dto.EmployeeDto;
import com.net.java.employeeservices.employeeservice.entity.EmployeeEntity;
import com.net.java.employeeservices.employeeservice.exception.ResourceNotFoundException;
import com.net.java.employeeservices.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepositoty repositoty;

	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDto saveEmployeeDetails(EmployeeDto dto) {

		EmployeeEntity employeeEntity = mapper.map(dto, EmployeeEntity.class);

		EmployeeEntity save = repositoty.save(employeeEntity);

		return mapper.map(save, EmployeeDto.class);

	}

	@Override
	public EmployeeDto getEmployeeDetailsById(Long id) {
		EmployeeEntity entity = repositoty.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
		return mapper.map(entity, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployeeDetails() {
		List<EmployeeEntity> findAll = repositoty.findAll();
		return findAll.stream().map((employee) -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());

	}

}
