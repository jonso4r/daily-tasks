package dev.jonatansoares.daily.tasks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/**",
						"/js/**").permitAll()
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/login/?logout").permitAll();
	}
}
