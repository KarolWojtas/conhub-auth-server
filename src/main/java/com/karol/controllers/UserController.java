package com.karol.controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karol.domain.AppUserDetails;


@RestController
public class UserController {
	
	@GetMapping("/me")
	public AppUserDetails userInfo() {
		return (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	
	
}
