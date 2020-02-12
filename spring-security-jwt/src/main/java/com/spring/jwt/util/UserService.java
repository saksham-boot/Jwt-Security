package com.spring.jwt.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
 
	private final JwtUtil jwtCreater;

	public UserService(JwtUtil jwtCreater) {
		this.jwtCreater = jwtCreater;
	}

	/**
	 * Spring security will call this method and passed the userName
	 * 
	 * this method basically fetch the data from database based on the unique id is
	 * passed here i.e userName
	 */
	
	/*
	 * 1) Normal user ----> user  ( normal , normal) 
	 * 2) Admin user ------> admin + superadmin (admin , admin)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = new ArrayList<>();

		/**
		 * List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new
		 * SimpleGrantedAuthority(role.getName().name()) ).collect(Collectors.toList());
		 */
		/**
		 * these roles would be fetched from database i.e based on userName
		 */
		;
			return new User("normal", "",authorities);
		

	}

	
	
	public String getToken(String name) {
		UserDetails details = loadUserByUsername(name);
		final String jwtToken = jwtCreater.generateToken(details);
		return jwtToken;
	}

}
