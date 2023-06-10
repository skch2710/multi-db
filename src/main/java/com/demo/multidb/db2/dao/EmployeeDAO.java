package com.demo.multidb.db2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.multidb.db2.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

}
