package com.adapsy.services;

import java.util.List;

import com.adapsy.model.Contact;

public interface ContactService {
	
	List<Contact> findAll();
	
	List<Contact> searchContacts(Contact criteria);
	
	Contact getContact(Long id);
	
	Long createContact(Contact contact);
	
	Boolean deleteContact(Long id);
	
	Boolean updateContact(Contact contact);
	
	Long createOrUpdateContact(Contact contact);

}
