package com.adapsy.services;

import java.util.List;

import com.adapsy.model.Contact;

public interface ContactService {
	
	List<Contact> findAll();
	
	List<Contact> searchContacts(Contact criteria);
	
	Contact getContact(Long id);
	
	Long createContact(Contact contact);

}
