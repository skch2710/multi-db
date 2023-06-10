package com.demo.multidb.db1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.multidb.db1.dao.StudentDAO;
import com.demo.multidb.db1.model.Student;
import com.demo.multidb.db1.service.StudentService;
import com.demo.multidb.db2.dao.EmployeeDAO;
import com.demo.multidb.db2.model.Employee;
import com.demo.multidb.dto.CombineDTO;
import com.demo.multidb.dto.CombineSearch;
import com.demo.multidb.dto.Result;
import com.demo.multidb.dto.StudentSearch;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Result saveStudent(Student student) {
		Result result = null;
		try {
			Student serverStudent = studentDAO.save(student);
			if (serverStudent != null) {
				result = new Result(serverStudent);
				result.setStatusCode(HttpStatus.OK.value());
				result.setSuccessMessage("Saved SuccusFully.");
			} else {
				result = new Result();
				result.setStatusCode(HttpStatus.BAD_REQUEST.value());
				result.setErrorMessage("Not Saved.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result getStudent(StudentSearch search) {
		Result result = null;
		try {
			Student student = studentDAO.findById(search.getStdId()).orElse(null);
			if (student != null) {
				result = new Result(student);
				result.setStatusCode(HttpStatus.OK.value());
				result.setSuccessMessage("geting SuccusFully.");
			} else {
				result = new Result();
				result.setStatusCode(HttpStatus.NO_CONTENT.value());
				result.setErrorMessage("Not Found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result getCombine(CombineSearch search) {
		Result result = null;
		try {
			Student student = studentDAO.findById(search.getStdId()).orElse(null);
			Employee employee = employeeDAO.findById(search.getEmpId()).orElse(null);
			if (student != null && employee != null) {
				CombineDTO combineDTO = new CombineDTO();
				combineDTO.setStudent(student);
				combineDTO.setEmployee(employee);
				
				result = new Result(combineDTO);
				result.setStatusCode(HttpStatus.OK.value());
				result.setSuccessMessage("geting SuccusFully.");
			} else {
				result = new Result();
				result.setStatusCode(HttpStatus.NO_CONTENT.value());
				result.setErrorMessage("Not Found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
