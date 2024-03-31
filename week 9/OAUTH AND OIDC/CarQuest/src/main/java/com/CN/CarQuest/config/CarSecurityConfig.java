package com.CN.CarQuest.config;

import com.CN.CarQuest.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CarSecurityConfig {

	@Autowired
	JwtAuthenticationFilter filter;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{
		
		http
			.csrf().disable()
			.authorizeHttpRequests()
			.antMatchers("/user/register","/auth/login").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception
	{
		return builder.getAuthenticationManager();
	}

	//Create Argon2 PasswordEncoder bean with properties as described in the problem statement
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		int saltLength = 16;
		int hashLength = 32;
		int parallelism = 4;
		int memory = 65536;
		int iterations = 5;
		Argon2PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder(
				saltLength,
				hashLength,
				parallelism,
				memory,
				iterations);
		
		return argon2PasswordEncoder;
				
	}

}
