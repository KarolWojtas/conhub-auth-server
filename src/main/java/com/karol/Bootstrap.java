package com.karol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.karol.domain.AppUserDetails;
import com.karol.services.interfaces.AppUserDetailsService;
@Component
public class Bootstrap implements CommandLineRunner{
	@Autowired
	private AppUserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public void run(String... args) throws Exception {
		if(userDetailsService.count()==0) {
			this.saveTestUser();
		}
		
	}
	private void saveTestUser() {
		AppUserDetails user = new AppUserDetails();
		user.setUsername("username");
		user.setPassword(passwordEncoder.encode("password"));
		user.setRoles("ROLE_USER");
		userDetailsService.saveUser(user);
	}
}