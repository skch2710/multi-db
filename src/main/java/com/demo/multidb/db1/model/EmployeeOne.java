package com.demo.multidb.db1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employee", schema = "public")
public class EmployeeOne {

	@Id
	private Long empId;

	private String fullName;

}
