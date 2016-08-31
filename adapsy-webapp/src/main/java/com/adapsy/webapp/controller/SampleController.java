package com.adapsy.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adapsy.model.Contact;
import com.adapsy.services.ContactService;

@RestController
@EnableAutoConfiguration
@ComponentScan("com.adapsy")
public class SampleController {
	
	@Autowired
	ContactService contactService;

    @GetMapping("/")
    List<Contact> home() {
    	return contactService.findAll();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
