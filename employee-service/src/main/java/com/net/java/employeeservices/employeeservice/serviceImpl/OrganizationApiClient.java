package com.net.java.employeeservices.employeeservice.serviceImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.net.java.employeeservices.employeeservice.dto.OrganizationDto;

@FeignClient(url = "http://localhost:8082", value = "ORGANIZATION-SERVICE")
public interface OrganizationApiClient {

	@GetMapping("/api/organization-service/organizationCode/{organization-code}")
	OrganizationDto getOrganizationDto(@PathVariable("organization-code") String organizationCode);

}
