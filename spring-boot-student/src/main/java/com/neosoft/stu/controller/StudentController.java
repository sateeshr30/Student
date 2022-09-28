package com.neosoft.stu.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.neosoft.stu.model.Student;
import com.neosoft.stu.repository.ContactRepository;
import com.neosoft.stu.repository.StudentRepository;
import com.neosoft.stu.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

	
	
	@Autowired
	StudentService studentService;
	

	
	
	@PostMapping
	public void addStudentDetails(@RequestBody Student student) {
		log.info("Inside addStudentDetails method of Student Controller",student);
		studentService.addStudent(student);
	}
	
	
	@GetMapping
	public List<Student> getAllStudentsDetails(){
		log.info("Inside getAllStudentDetails method of Student Controller");
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{rollno}")
	public Optional<Student> getStudentDetailsByRollno(@PathVariable Integer rollno){
		log.info("Inside getStudentDetailsByRollno method of Student Controller");
		return studentService.getStudentById(rollno);
	}
	
	@PutMapping("/{rollno}")
	public void updateStudent(@PathVariable Integer rollno, @RequestBody Student student) {
		log.info("Inside updateStudent method of Student Controller");
		studentService.updateStudentDetails(rollno, student);
	}
	
	@DeleteMapping("/{rollno}")
	public void deleteStudent(@PathVariable Integer rollno) {
		log.info("Inside deleteStudent method of Student Controller");
		studentService.deleteStudent(rollno);
	}
	
	
	
	
	
	
}
