package com.spring.jwt.util;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	/**
	 * Spring security will call this method and passed the userName
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return new User("demo", "demo", new ArrayList<>());
	}
	
	@Bean
	public PasswordEncoder passwordEncode()
	{
		return NoOpPasswordEncoder.getInstance();
	}

}
