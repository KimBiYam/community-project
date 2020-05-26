package com.myapp.community.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private LoginFailureHandler loginFailureHandler;
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.authorizeRequests()
				.antMatchers("/admin/*").hasRole("ADMIN")
				.antMatchers("/*").permitAll()
			.and()
				.formLogin()
				.loginPage("/member/login")
				.loginProcessingUrl("/member/login")
				.defaultSuccessUrl("/")
				.failureHandler(loginFailureHandler)
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
			.and()
				.exceptionHandling().accessDeniedPage("/member/denied");
				
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		this.passwordEncoder = new BCryptPasswordEncoder();
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(customUserDetailsService)
			.passwordEncoder(passwordEncoder);
	}
	
	
}
