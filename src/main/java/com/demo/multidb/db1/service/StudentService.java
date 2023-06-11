package com.demo.multidb.db1.service;

import com.demo.multidb.db1.model.Student;
import com.demo.multidb.db2.model.Employee;
import com.demo.multidb.dto.CombineSearch;
import com.demo.multidb.dto.Result;
import com.demo.multidb.dto.StudentSearch;

public interface StudentService {

	Result saveStudent(Student student);

	Result getStudent(StudentSearch search);

	Result getCombine(CombineSearch search);

	Result saveCombine(Employee employee);

}
