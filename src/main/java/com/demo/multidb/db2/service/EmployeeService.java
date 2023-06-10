package com.demo.multidb.db2.service;

import com.demo.multidb.db2.model.Employee;
import com.demo.multidb.dto.EmployeeSearch;
import com.demo.multidb.dto.Result;

public interface EmployeeService {

	Result saveEmployee(Employee employee);

	Result getEmployee(EmployeeSearch search);

}
