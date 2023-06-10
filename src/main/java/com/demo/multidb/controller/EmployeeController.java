package com.demo.multidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.multidb.db2.model.Employee;
import com.demo.multidb.db2.service.EmployeeService;
import com.demo.multidb.dto.EmployeeSearch;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/employee")
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save-employee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}

	@PostMapping("/get-employee")
	public ResponseEntity<?> getEmployee(@RequestBody EmployeeSearch search) {
		return ResponseEntity.ok(employeeService.getEmployee(search));
	}

}
