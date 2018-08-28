package com.karol.interceptors;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("interceptooor");
		Enumeration<String> headerEnumeration = request.getHeaderNames();
		while(headerEnumeration.hasMoreElements()) {
			System.out.println(headerEnumeration.nextElement());
		}
		
		return super.preHandle(request, response, handler);
	}

}
