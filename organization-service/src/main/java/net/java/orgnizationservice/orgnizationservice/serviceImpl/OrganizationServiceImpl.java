package net.java.orgnizationservice.orgnizationservice.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.java.orgnizationservice.orgnizationservice.dto.OrganizationDto;
import net.java.orgnizationservice.orgnizationservice.entity.Orgnization;
import net.java.orgnizationservice.orgnizationservice.exception.ResourceNotFoundException;
import net.java.orgnizationservice.orgnizationservice.repo.OrganizationRepo;
import net.java.orgnizationservice.orgnizationservice.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);
	
	@Autowired
	OrganizationRepo repo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public OrganizationDto saveOrganizationDetails(OrganizationDto dto) {
		System.out.println("date :: "+dto.getCreatedDate());
		Orgnization map = mapper.map(dto, Orgnization.class);
		Orgnization orgnization = repo.save(map);
		return mapper.map(orgnization, OrganizationDto.class);

	}

	@Override
	public List<OrganizationDto> getAllOrgDetails() {
		// TODO Auto-generated method stub
		List<Orgnization> findAll = repo.findAll();
		
		return findAll.stream().map((org) -> mapper.map(org, OrganizationDto.class)).collect(Collectors.toList());
	}

	@Override
	public OrganizationDto getOrgnizationById(long id) {
		
				Orgnization orgnization = repo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Organization", "ID", id)
				);
		
		return mapper.map(orgnization, OrganizationDto.class);
	}

	@Override
	public OrganizationDto getOrganizationCode(String code) {
		Orgnization orgnization = repo.findByorganizationCode(code);
				
		return mapper.map(orgnization, OrganizationDto.class);
	}

}
