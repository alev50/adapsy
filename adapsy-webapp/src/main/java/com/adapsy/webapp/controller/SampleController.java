package com.adapsy.webapp.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {
	
	@Autowired
	DataSource datasource;

    @RequestMapping("/")
    @ResponseBody
    String home() {
    	String output = null;
    	
    	try {
	    	Connection conn = datasource.getConnection();
	        
	    	try {
	    		Statement stat = conn.createStatement();
	    		
	    		try {
	    			ResultSet res = stat.executeQuery("select count(*) from contact");
	    			
	    			try {
	    				if (res.next()) {
	    					int nb = res.getInt(1);
	    					
	    					output = MessageFormat.format("Il y a {0} contact(s) dans la base.", nb);
	    				}
	    			} finally {
	    				res.close();
	    			}
	    		} finally {
	    			stat.close();
	    		}
	    	} finally {
	    		conn.close();
	    	}
    	} catch (Exception e) {
    		output = e.getMessage();
    	}
    	
    	return output;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
