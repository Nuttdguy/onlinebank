//package com.app.config;
//
//import java.security.SecureRandom;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.app.service.UserSecurityService;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private Environment env;
//	
//	@Autowired
//	private UserSecurityService userSecurityService;
//
//	private static final String SALT = "salt";
//	
//	@Bean 
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
//	}
//	
//	private static final String[] PUBLIC_MATCHERS = {
//            "/webjars/**",
//            "/css/**",
//            "/js/**",
//            "/images/**",
//            "/",
//            "/about/**",
//            "/contact/**",
//            "/error/**/*",
//            "/console/**",
//            "/signup",
//            "/index"
//	};
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//			.antMatchers(PUBLIC_MATCHERS)
//			.permitAll().anyRequest()
//			.anonymous();
//		
//		
//	}
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
//	}
//	
//}
