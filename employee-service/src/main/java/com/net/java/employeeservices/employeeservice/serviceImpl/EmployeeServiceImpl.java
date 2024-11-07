package com.net.java.employeeservices.employeeservice.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.net.java.employeeservices.employeeservice.Repositoty.EmployeeRepositoty;
import com.net.java.employeeservices.employeeservice.dto.ApiResponce;
import com.net.java.employeeservices.employeeservice.dto.DepartmentDto;
import com.net.java.employeeservices.employeeservice.dto.EmployeeDto;
import com.net.java.employeeservices.employeeservice.dto.OrganizationDto;
import com.net.java.employeeservices.employeeservice.entity.EmployeeEntity;
import com.net.java.employeeservices.employeeservice.exception.ResourceNotFoundException;
import com.net.java.employeeservices.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepositoty repositoty;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private WebClient webClient;

	@Autowired
	private DepartmentApiClient departmentApiClient;
	
	@Autowired
	OrganizationApiClient organizationApiClient;

	@Override
	public EmployeeDto saveEmployeeDetails(EmployeeDto dto) {

		EmployeeEntity employeeEntity = mapper.map(dto, EmployeeEntity.class);

		EmployeeEntity save = repositoty.save(employeeEntity);

		return mapper.map(save, EmployeeDto.class);

	}

	@Override
	public ApiResponce getEmployeeDetailsById(Long id) {
		LOGGER.info("getEmployeeDetailsById :: " + id);

		EmployeeEntity entity = repositoty.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
//		return mapper.map(entity, EmployeeDto.class);

//		DepartmentDto departmentDto = webClient.get()
//				.uri("http://localhost:8081/api/departments/get-department-code/" + entity.getdepartmentcode())
//				.retrieve().bodyToMono(DepartmentDto.class).block();
		DepartmentDto departmentDto = departmentApiClient.getDepartment(entity.getdepartmentcode());
		// return mapper.map(departmentDto, EmployeeDto.class);

		EmployeeDto employeeDto = mapper.map(entity, EmployeeDto.class);

//		OrganizationDto organizationDto = webClient.get().uri("http://localhost:8082/api/organization-service/get-organizationCode/"+entity.getOrganizationCode())
//				.retrieve().bodyToMono(OrganizationDto.class).block();
		
		OrganizationDto organizationDto = organizationApiClient.getOrganizationDto(entity.getOrganizationCode());
	
		ApiResponce apiResponce = new ApiResponce();
		apiResponce.setEmployeeDto(employeeDto);
		apiResponce.setDepartmentDto(departmentDto);
		apiResponce.setOrganizationDto(organizationDto);

		return apiResponce;

	}

	@Override
	public List<EmployeeDto> getAllEmployeeDetails() {
		List<EmployeeEntity> findAll = repositoty.findAll();
		return findAll.stream().map((employee) -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());

	}

}
