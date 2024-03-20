package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.example.demo.security.CustomAccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.antMatchers("/", "/home").permitAll().antMatchers("/empList")
				.hasRole("ADMIN").anyRequest().authenticated())
//				.formLogin((form) -> form.loginPage("/login").permitAll()).logout((logout) -> logout.permitAll())
//				.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
				.formLogin()
				.loginPage("/login")
				.usernameParameter("userId")
				.loginProcessingUrl("userLogin")
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling(handler -> handler.accessDeniedHandler(accessDeniedHandler()));
				
//			.csrf().disable();

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		// user 계정
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("1111").roles("USER").build();

		// admin 계정
		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("1111").roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user, admin);
	}
}