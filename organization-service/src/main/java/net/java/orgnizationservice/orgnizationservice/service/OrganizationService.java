package net.java.orgnizationservice.orgnizationservice.service;



import java.util.List;

import org.springframework.stereotype.Repository;

import net.java.orgnizationservice.orgnizationservice.dto.OrganizationDto;

@Repository
public interface OrganizationService {

	public OrganizationDto saveOrganizationDetails(OrganizationDto dto);

	public List<OrganizationDto> getAllOrgDetails();

	public OrganizationDto getOrgnizationById(long id);

	
	public OrganizationDto getOrganizationCode(String code);
}
