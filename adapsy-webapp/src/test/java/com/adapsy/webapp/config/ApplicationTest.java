package com.adapsy.webapp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = { "com.adthruster.services", "com.adthruster.webapp.controller" })
public class ApplicationTest {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationTest.class, args);
	}

}
