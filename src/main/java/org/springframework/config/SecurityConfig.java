package org.springframework.samples.petclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	InMemoryUserDetailsManager userDetailsService() {
      UserDetails users = User.withDefaultPasswordEncoder()
			.username("ajay")
			.password("ajay123")
			.roles("USER")
            .build();
             return new InMemoryUserDetailsManager(users);
	}

}