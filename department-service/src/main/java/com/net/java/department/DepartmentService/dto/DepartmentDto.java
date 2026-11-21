package com.net.java.department.DepartmentService.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
//@Table(name = "department_dto")
public class DepartmentDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "Department Code should not be null or Blank")
	private String departmentcode;

	@NotEmpty(message = "Department discription should not be null or Blank")
	private String departmentDescription;

	@NotEmpty(message = "Department Name should not be null or Blank")
	private String departmentName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentcode() {
		return departmentcode;
	}

	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "DepartmentDto [id=" + id + ", departmentcode=" + departmentcode + ", departmentDescription="
				+ departmentDescription + ", departmentName=" + departmentName + "]";
	}

}
