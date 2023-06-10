package com.demo.multidb.dto;

import com.demo.multidb.db1.model.Student;
import com.demo.multidb.db2.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombineDTO {

	private Student student;
	private Employee employee;

}
