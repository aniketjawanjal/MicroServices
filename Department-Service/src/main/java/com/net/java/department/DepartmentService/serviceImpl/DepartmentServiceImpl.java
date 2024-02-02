package com.net.java.department.DepartmentService.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.java.department.DepartmentService.dto.DepartmentDto;
import com.net.java.department.DepartmentService.entity.DepartmentEntity;
import com.net.java.department.DepartmentService.exception.ResourceNotFoundException;
import com.net.java.department.DepartmentService.repository.DepartmentRepositoty;
import com.net.java.department.DepartmentService.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepositoty repositoty;

	@Autowired
	ModelMapper mapper;

	@Override
	public DepartmentDto saveDepartmentDetails(DepartmentDto entity) {

		System.out.println("entity :: "+entity);
		DepartmentEntity mapToDepartment = mapper.map(entity, DepartmentEntity.class);
		DepartmentEntity departmentEntity = repositoty.save(mapToDepartment);
		DepartmentDto mapToDepartmentDto = mapper.map(departmentEntity, DepartmentDto.class);
		return mapToDepartmentDto;
	}

	@Override
	public List<DepartmentDto> getAllDepartmentDetails() {
		List<DepartmentEntity> findAll = repositoty.findAll();

		return findAll.stream().map((department) -> mapper.map(department, DepartmentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto getDepartmentsById(long id) {

		DepartmentEntity find = repositoty.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "ID ", id));

		return mapper.map(find, DepartmentDto.class);
	}

}
