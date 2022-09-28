package com.neosoft.stu;



import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.neosoft.stu.enume.ContactType;
import com.neosoft.stu.model.Contact;
import com.neosoft.stu.model.Student;
import com.neosoft.stu.repository.ContactRepository;
import com.neosoft.stu.repository.StudentRepository;



@SpringBootTest
class SpringBootStudentApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Autowired
	private ContactRepository contactRepository;
	
	
    @Test
   @DisplayName("should save student")
    @Rollback(value = false)
    @Order(1)
    public void saveStudentTest(){
    		List<Contact> list = new ArrayList<Contact>();
    		
    		Contact c = new Contact();
    		
    		c.setId(1);
    		c.setName("max");
    		c.setRelationship("father");
    		c.setContactType(ContactType.MOBILE);
    		c.setPhoneNumber("9876543321");
    		
    		list.add(c);
    		
    		Student s = new Student();
    		
    		s.setRollNo(1);
    		s.setFullName("ms");
    		s.setJoinedDate(new Date(9/9/2022));
    		s.setContacts(list);
    		
    		studentRepository.save(s);
    		assertNotNull(studentRepository.findById(1).isPresent() ? studentRepository.findById(1).get():null);
   
    	}
	
	
    @Test
    @Order(3)
    public void getAllStudents () {
    	List list = studentRepository.findAll();
    	assertThat(list).size().isGreaterThan(0);
    }
	
	
	  @Test 
	  @Order(2)
	  public void getStudent () {
			/*
			 * Student student = studentRepository.findById(1).isPresent() ?
			 * studentRepository.findById(1).get():null;
			 * 
			 * assertEquals("ms", student.getFullName());
			 */
	  Student student = studentRepository.findById(1).get();
	  System.out.println(student);
	  Assertions.assertThat(student.getRollNo()).isEqualTo(1);
	  
	  }
	 
	
	/*
	 * @Test
	 *  @Order(3) public void updateStudent () {
	 * 
	 * List<Contact> list = new ArrayList<Contact>();
	 * 
	 * Contact c = new Contact();
	 * 
	 * c.setId(1); c.setName("max"); c.setRelationship("father");
	 * c.setContactType(ContactType.MOBILE); c.setPhoneNumber("9876543321");
	 * 
	 * list.add(c);
	 * 
	 * 
	 * Student s = studentRepository.findById(1).get(); s.setRollNo(1);
	 * s.setFullName("abd"); s.setJoinedDate(new Date(9/9/2022));
	 * s.setContacts(list);
	 * 
	 * studentRepository.save(s); assertNotEquals(1,
	 * studentRepository.findById(1).get().getRollNo()); }
	 */
    
	
	
	  @Test
	  @Order(4)//(expected = NullPointerException.class)
	  public void deleteStudent () {
	 // 
	//  studentRepository.deleteById(1);
	//  assertThat(studentRepository.findById(1).get(),is(null)); 
		  Student student = studentRepository.findById(1).get();
		  studentRepository.delete(student);
		  
		  Student student1 = null;
		  
		  Optional<Student> optionalStudent = studentRepository.findById(1);
		  
		  if(optionalStudent.isPresent()) {
			  student1 = optionalStudent.get();
		  }
		  
		  Assertions.assertThat(student1).isNull();
	
	  }
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

private void assertNotNull(Object student) {
		// TODO Auto-generated method stub
		
	}



private void assertEquals(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

  private void assertNotNull(Student student) {
		// TODO Auto-generated method stub
		
	}
    


  private void assertNotEquals(long l, long roomid) {
		// TODO Auto-generated method stub
		
	}
  private void assertEquals(int i, long totalrooms) {
		// TODO Auto-generated method stub
		
	}
  
	private void assertNotEquals(String string, String buildingnum) {
		// TODO Auto-generated method stub
		
	}



	private void assertNotEquals(int i, long l) {
		// TODO Auto-generated method stub
		
	}

	
	@Test
	void contextLoads() {
	}

}
