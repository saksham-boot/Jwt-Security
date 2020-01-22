package com.spring.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jwt.models.AuthorizationRequest;
import com.spring.jwt.models.AuthorizationResponse;

@RestController
public class HelloController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService userDetailService;

	@Autowired
	JwtUtil jwtCreater;

	@RequestMapping(method = RequestMethod.GET, value = "/security")
	public String hello() {
		return "Welcome to Spring Security with JWT";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/Authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthorizationRequest authorizationRequest) {
		/*
		 * Authentication manager will go to Authentication Providers(Many providers are
		 * there) for Authentication userName and Password
		 */
		Authentication authProvider = new UsernamePasswordAuthenticationToken(authorizationRequest.getUsername(),
				authorizationRequest.getPassword());
		try {
			authenticationManager.authenticate(authProvider);

		} catch (BadCredentialsException e) {
			return new ResponseEntity<>("Incorrect Credentials", HttpStatus.NOT_FOUND);
		}

		/**
		 * when credentails are correct then load the userDetails , by using
		 * loadUsername --> fetch the data and produce JWT.
		 */

		UserDetails details = userDetailService.loadUserByUsername(authorizationRequest.getUsername());

		final String jwtToken = jwtCreater.generateToken(details);
		
			

		return new ResponseEntity<>(new AuthorizationResponse(jwtToken), HttpStatus.OK);

	}
}
