package com.karol.services.interfaces;

import com.karol.domain.AppUserDetails;

public interface AppUserDetailsService {
	public AppUserDetails saveUser(AppUserDetails userDetails);
	public long count();
}
