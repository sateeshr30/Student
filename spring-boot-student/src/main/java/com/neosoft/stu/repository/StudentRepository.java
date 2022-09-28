package com.neosoft.stu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.stu.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
