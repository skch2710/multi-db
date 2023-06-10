package com.demo.multidb.db1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.multidb.db1.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Long> {

}
