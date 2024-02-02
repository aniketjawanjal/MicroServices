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
	private String department_code;
	private String department_discription;
	private String department_name;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartment_code() {
		return department_code;
	}

	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}

	public String getDepartment_discription() {
		return department_discription;
	}

	public void setDepartment_discription(String department_discription) {
		this.department_discription = department_discription;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", department_code=" + department_code + ", department_discription="
				+ department_discription + ", department_name=" + department_name + "]";
	}

}
