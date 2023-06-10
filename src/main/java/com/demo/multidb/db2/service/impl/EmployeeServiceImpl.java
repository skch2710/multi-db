package com.demo.multidb.db2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.multidb.db2.dao.EmployeeDAO;
import com.demo.multidb.db2.model.Employee;
import com.demo.multidb.db2.service.EmployeeService;
import com.demo.multidb.dto.EmployeeSearch;
import com.demo.multidb.dto.Result;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Result saveEmployee(Employee employee) {
		Result result = null;
		try {
			Employee serverEmployee = employeeDAO.save(employee);
			if (serverEmployee != null) {
				result = new Result(serverEmployee);
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
	public Result getEmployee(EmployeeSearch search) {
		Result result = null;
		try {
			Employee employee = employeeDAO.findById(search.getEmpId()).orElse(null);
			if (employee != null) {
				result = new Result(employee);
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
