package com.transion.backend.conf;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conf {
	
	@Bean
	public ModelMapper getDTOMapper() {
		return new ModelMapper();
	}
}
