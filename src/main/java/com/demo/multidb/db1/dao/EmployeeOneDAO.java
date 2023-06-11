package com.demo.multidb.db1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.multidb.db1.model.EmployeeOne;

@Repository
public interface EmployeeOneDAO extends JpaRepository<EmployeeOne, Long> {

}
