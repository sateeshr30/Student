package com.neosoft.stu.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.stu.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	//public List<Contacts> findByNameContacts(String Name);

}
