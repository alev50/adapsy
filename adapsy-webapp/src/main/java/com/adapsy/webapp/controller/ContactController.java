package com.adapsy.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adapsy.model.Contact;
import com.adapsy.services.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	ContactService contactService;

	@GetMapping("/contacts")
	@ResponseBody List<Contact> getContacts() {
		return contactService.findAll();
	}
	
	@GetMapping("/contacts/{id}")
	@ResponseBody Contact getContacts(@PathVariable("id") Long id) {
		return contactService.getContact(id);
	}
	
	@PostMapping("/contacts/searches")
	@ResponseBody List<Contact> findContacts(@RequestBody Contact criteria) {
		return contactService.searchContacts(criteria);
	}
	
	@PostMapping("/contacts")
	@ResponseBody Long createOrUpdateContact(@RequestBody Contact contact) {
		return contactService.createOrUpdateContact(contact);
	}
	
	@DeleteMapping("/contacts/{id}")
	@ResponseBody Boolean createContact(@PathVariable("id") Long id) {
		return contactService.deleteContact(id);
	}
	
	@PutMapping("/contacts/{id}")
	@ResponseBody Long createOrUpdateContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
		contact.setId(id);
		
		return contactService.createOrUpdateContact(contact);
	}

}
