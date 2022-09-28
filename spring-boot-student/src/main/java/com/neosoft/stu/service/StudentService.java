package com.neosoft.stu.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.neosoft.stu.model.Student;
import com.neosoft.stu.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentapirepo;
	
	
	
	public List<Student> getAllStudents(){
		log.info("Inside getAllStudents method of StudentService");
		return studentapirepo.findAll();
	}
	
	
	
	public void addStudent(Student student) {
		log.info("Inside addStudent method of StudentService",student);
		studentapirepo.save(student);
	}
	
	public Optional<Student> getStudentById(Integer rollNo){
		log.info("Inside getStudentById  method of StudentService",rollNo);
		return studentapirepo.findById(rollNo);
	}
	
	
	public void updateStudentDetails(Integer rollNo, Student student) {
		log.info("Inside updateStudentDetails  method of StudentService",rollNo,student);
		Student stuDetails = studentapirepo.getById(rollNo);
		
		stuDetails.setFullName(student.getFullName());
		stuDetails.setJoinedDate(student.getJoinedDate());
		stuDetails.setContacts(student.getContacts());
	
		
		studentapirepo.save(stuDetails);
	}
	
	public void deleteStudent(Integer rollNo) {
		log.info("Inside deleteStudent  method of StudentService",rollNo);
		studentapirepo.deleteById(rollNo);
	}

}
