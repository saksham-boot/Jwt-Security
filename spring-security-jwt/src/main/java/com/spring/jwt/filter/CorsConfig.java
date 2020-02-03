package com.spring.jwt.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig {

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	@Bean
	public FilterRegistrationBean<GenericFilterBean> corsFilter() {
		
		final FilterRegistrationBean<GenericFilterBean > bean = new FilterRegistrationBean<GenericFilterBean >();
		
		bean.setFilter(jwtRequestFilter);
		bean.addUrlPatterns("/security/*");
		bean.setOrder(0);
		
		return bean;
	}

	
}
