package com.demo.multidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.multidb.db1.model.Student;
import com.demo.multidb.db1.service.StudentService;
import com.demo.multidb.dto.CombineSearch;
import com.demo.multidb.dto.StudentSearch;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/student")
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/save-students")
	public ResponseEntity<?> saveStudents(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.saveStudent(student));
	}

	@PostMapping("/get-students")
	public ResponseEntity<?> getStudents(@RequestBody StudentSearch search) {
		return ResponseEntity.ok(studentService.getStudent(search));
	}
	
	@PostMapping("/get-combine")
	public ResponseEntity<?> getCombine(@RequestBody CombineSearch search) {
		return ResponseEntity.ok(studentService.getCombine(search));
	}

}
