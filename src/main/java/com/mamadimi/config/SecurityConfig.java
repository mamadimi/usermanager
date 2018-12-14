package com.mamadimi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	private final String USER_QUERY = "select email, password, active as enabled  from users where email= ?";
	private final String ROLE_QUERY = "select u.email, r.role from users u, users r where u.id = r.id and u.email = ?";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication()
			 .dataSource(dataSource)
			 .usersByUsernameQuery(USER_QUERY)
			 .authoritiesByUsernameQuery(ROLE_QUERY)
			 .passwordEncoder(bCryptPasswordEncoder) //just for debuging
			
			;
	}

	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	    	.antMatchers("/").permitAll()
	    	.antMatchers("/login").permitAll()
	    	.antMatchers("/register").permitAll()
	    	.antMatchers("/profile/**").hasAnyAuthority("ROLE_USER")
	    	.and()
	    	.csrf().disable()
	    	
	    	.formLogin().loginPage("/login")
	    	.defaultSuccessUrl("/profile")
	    	.usernameParameter("email")
	    	.passwordParameter("password")
	    	
	    	.and()
	    	.logout().logoutSuccessUrl("/login?logout"); 
	    	
	    	;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptEncoder() {
		return new BCryptPasswordEncoder();
	}
}
