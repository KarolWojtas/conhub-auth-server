package com.karol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.karol.domain.AppUserDetails;
import com.karol.interfaces.feign.UserServiceProxy;
import com.karol.services.interfaces.AppUserDetailsService;
@Service
public class AppUserDetailsServiceImpl implements AppUserDetailsService{
	private UserServiceProxy userDetailsProxy;
	
	@Autowired
	public AppUserDetailsServiceImpl(UserServiceProxy userDetailsProxy) {
		super();
		this.userDetailsProxy = userDetailsProxy;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userDetailsProxy.loadUserByUsername(username); 
		
	}

	

}
