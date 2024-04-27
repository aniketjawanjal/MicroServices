package com.net.java.employeeservices.employeeservice.dto;


public class DepartmentDto {
	private Long id;

	private String departmentName;
	private String departmentDescription;
	private String departmentcode;

	public DepartmentDto(Long id, String departmentName, String departmentDescription, String departmentcode) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departmentcode = departmentcode;
	}

	public DepartmentDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public String getdepartmentcode() {
		return departmentcode;
	}

	public void setdepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}

	@Override
	public String toString() {
		return "DepartmentDto [id=" + id + ", departmentName=" + departmentName + ", departmentDescription="
				+ departmentDescription + ", departmentcode=" + departmentcode + "]";
	}

}
