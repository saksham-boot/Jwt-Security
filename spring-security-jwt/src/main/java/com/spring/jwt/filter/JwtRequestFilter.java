package com.spring.jwt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.spring.jwt.util.JwtUtil;
import com.spring.jwt.util.UserService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;

@Component
public class JwtRequestFilter extends GenericFilterBean  {

	@Autowired
	UserService userService;

	@Autowired
	JwtUtil jwtUtil;

	 
	 
	@Override
	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		String jwtToken = null;
		String userName = null;
		
		final HttpServletRequest request = (HttpServletRequest) request1;
		final HttpServletResponse response = (HttpServletResponse) response1;
		
		final String authorizationHeader = request.getHeader("Authorization");
		boolean jwtResult = false;
		
		
		 if ("OPTIONS".equals(request.getMethod())) {
		        response.setStatus(HttpServletResponse.SC_OK);

		        filterChain.doFilter(request, response); // go to next filter 
		    } 
		 
		 if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {

			 response.setStatus(HttpStatus.UNAUTHORIZED.value());
				
				return;
		 }
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

			jwtToken = authorizationHeader.substring(7);

			try {
			userName = jwtUtil.extractUsername(jwtToken);
			}catch (JwtException e) {
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				
				return;
			}
		}

		if (userName != null) {
			UserDetails userDetails = userService.loadUserByUsername(userName);

			
			try {
		    jwtResult = jwtUtil.validateToken(jwtToken, userDetails);
			}
			catch (ExpiredJwtException e) {
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				return;
			}
			
			if(!jwtResult)
			{
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				return;
			}
			
				/**
				 * what would have default by spring security , automatically.
				 * we are only doing this when we have a valid jwt Token.
				 * 
				 */
				
				
				
			
		}

		filterChain.doFilter(request, response); // go to next filter 

	}

	

}
