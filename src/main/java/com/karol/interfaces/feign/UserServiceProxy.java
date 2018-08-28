package com.karol.interfaces.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.karol.domain.AppUserDetails;

@FeignClient("conhub-user-service")
public interface UserServiceProxy {
	@GetMapping("/users/{username}")
	AppUserDetails loadUserByUsername(@PathVariable("username") String username);
}
