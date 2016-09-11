package com.adapsy.webapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.adapsy.model.Contact;
import com.adapsy.webapp.config.ApplicationTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {
	
	private TestRestTemplate template = new TestRestTemplate();
	
	 @LocalServerPort
	 private int port;
	 
	@Test
	public void testCreateContact() throws Exception {
		Contact contact = new Contact();
		
		contact.setPrenom("Rym");
		contact.setNom("Jabeur");
		
		ResponseEntity<Object> response = this.template.postForEntity("http://localhost:" + port + "/contacts", contact, Object.class);
		
		System.out.println(response.toString());
	}
	
	@Test
	public void testFindAll() throws Exception {
		ResponseEntity<Object> response = this.template.getForEntity("http://localhost:" + port + "/contacts", Object.class);
		
		System.out.println(response.toString());
	}
	
	@Test
	public void testGetContact() throws Exception {
		ResponseEntity<Object> response = this.template.getForEntity("http://localhost:" + port + "/contacts/1", Object.class);
		
		System.out.println(response.toString());
	}
	
	@Test
	public void testSearchContacts() throws Exception {
		Contact criteria = new Contact();
		
		criteria.setPrenom("Thomas");
		
		ResponseEntity<Object> response = this.template.postForEntity("http://localhost:" + port + "/contacts/searches", criteria, Object.class);
		
		System.out.println(response.toString());
	}

}
