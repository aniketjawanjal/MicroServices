package com.net.java.department.DepartmentService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String departmentcode;
	private String departmentDiscription;
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

	public String getDepartmentDiscription() {
		return departmentDiscription;
	}

	public void setDepartmentDiscription(String departmentDiscription) {
		this.departmentDiscription = departmentDiscription;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", departmentcode=" + departmentcode + ", departmentDiscription="
				+ departmentDiscription + ", departmentName=" + departmentName + "]";
	}

}
