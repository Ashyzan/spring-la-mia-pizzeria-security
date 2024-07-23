package it.ashyzan.pizzeria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				// qui va messa l'url da tenere sotto controllo
				.requestMatchers("/offerte/edit", "/pizzeria/edit/**").hasAuthority("ADMIN")
				.requestMatchers(HttpMethod.POST, "/pizzeria/**").hasAuthority("ADMIN").requestMatchers("/admin")
				.hasAnyAuthority("ADMIN", "USER").requestMatchers("/**").permitAll().and().formLogin().and().logout()
				.and().exceptionHandling();

		return http.build();

	}

}
