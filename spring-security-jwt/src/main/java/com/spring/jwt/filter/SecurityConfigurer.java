/*
 * package com.spring.jwt.filter;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.web.servlet.FilterRegistrationBean; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter; import
 * org.springframework.security.web.authentication.www.
 * BasicAuthenticationFilter; import
 * org.springframework.web.filter.GenericFilterBean;
 * 
 * import com.spring.jwt.filter.JwtRequestFilter; import
 * com.spring.jwt.util.UserService;
 * 
 * @EnableWebSecurity public class SecurityConfigurer extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private UserService userService;
 * 
 * @Autowired private JwtRequestFilter jwtRequestFilter;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.requestMatchers().antMatchers("/security/*").and()
 * .addFilterBefore(jwtRequestFilter,
 * BasicAuthenticationFilter.class).authorizeRequests().anyRequest()
 * .authenticated();
 * 
 * }
 * 
 * }
 */