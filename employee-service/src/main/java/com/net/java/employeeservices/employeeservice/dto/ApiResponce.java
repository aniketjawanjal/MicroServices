package com.net.java.employeeservices.employeeservice.dto;

public class ApiResponce {

	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;
	private OrganizationDto organizationDto;

	public ApiResponce() {
		super();
	}

	public ApiResponce(EmployeeDto employeeDto, DepartmentDto departmentDto, OrganizationDto organizationDto) {
		super();
		this.employeeDto = employeeDto;
		this.departmentDto = departmentDto;
		this.organizationDto = organizationDto;
	}

	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}

	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

	public OrganizationDto getOrganizationDto() {
		return organizationDto;
	}

	public void setOrganizationDto(OrganizationDto organizationDto) {
		this.organizationDto = organizationDto;
	}

	@Override
	public String toString() {
		return "ApiResponce [employeeDto=" + employeeDto + ", departmentDto=" + departmentDto + ", organizationDto="
				+ organizationDto + "]";
	}

}
