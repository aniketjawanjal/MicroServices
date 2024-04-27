package net.java.orgnizationservice.orgnizationservice.controller;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.orgnizationservice.orgnizationservice.dto.OrganizationDto;
import net.java.orgnizationservice.orgnizationservice.service.OrganizationService;

@RestController
@RequestMapping("api/organization-service")
public class OrgnizationController {

	@Autowired
	OrganizationService service;

	@GetMapping
	public String getStart() {
		return "Organization Service Start";
	}

	@PostMapping("/save-organization")
	public ResponseEntity<OrganizationDto> saveOrganizationDetails(@RequestBody OrganizationDto dto) {
	OrganizationDto details = service.saveOrganizationDetails(dto);
		return new ResponseEntity<>(details, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-details")
	public ResponseEntity<List<OrganizationDto>> getAllOrganizationDetails(){
		List<OrganizationDto> details = service.getAllOrgDetails();
		return new ResponseEntity<>(details, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrganizationDto> getOrganizationById(@PathVariable long id){
		OrganizationDto dto = service.getOrgnizationById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/get-organizationCode/{id}")
	public ResponseEntity<OrganizationDto> getOrganizationCode(@PathVariable String id){
		OrganizationDto dto = service.getOrganizationCode(id);
		return ResponseEntity.ok(dto);
	}
	
}
