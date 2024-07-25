package it.ashyzan.pizzeria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		// qui va messa l'url da tenere sotto controllo
//		.requestMatchers("/offerte/edit", "/pizzeria/edit/**").hasAuthority("ADMIN")
//		.requestMatchers(HttpMethod.POST, "/pizzeria/**").hasAuthority("ADMIN")
//		.requestMatchers("/css/**", "/js/**", "/webjars/**", "/img/**").permitAll()
//		.requestMatchers("/admin").hasAnyAuthority("ADMIN", "USER")
		.requestMatchers("/**").permitAll().and().formLogin().and().logout()
		.and().exceptionHandling().and().csrf().disable();
//csrf cross site request forgery in questo caso è disabilitato epr permettere la post
		return http.build();

	}

}
