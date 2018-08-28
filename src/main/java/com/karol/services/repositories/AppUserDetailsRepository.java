package com.karol.services.repositories;

import org.springframework.data.repository.CrudRepository;

import com.karol.domain.AppUserDetails;

public interface AppUserDetailsRepository extends CrudRepository<AppUserDetails, Long>{
	AppUserDetails findByUsername(String username);
}
