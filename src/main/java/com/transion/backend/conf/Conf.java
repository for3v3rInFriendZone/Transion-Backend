package com.transion.backend.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Conf {

	@Bean
	public BCryptPasswordEncoder getBCypt() {
		return new BCryptPasswordEncoder();
	}
}
