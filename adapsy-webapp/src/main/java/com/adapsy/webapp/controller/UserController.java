package com.adapsy.webapp.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adapsy.services.ContactService;

@RestController
public class UserController {

	@Autowired
	ContactService contactService;

	@GetMapping({ "/user", "/me" })
	@ResponseBody
	public Map<String, String> user(Principal principal) {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("name", principal.getName());

		return map;
	}
	
}
