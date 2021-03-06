package br.com.b2w.starwars.api.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.b2w.starwars.api.config.RestClientConfiguration;
import br.com.b2w.starwars.api.dto.PlanetMapper;

@Configuration
@Import(RestClientConfiguration.class)
public class ServiceConfig {
	
	@Bean
	public RestTemplateBuilder restTemplateBuilder() {
		return new RestTemplateBuilder();
	}

	@Bean
	public SWApi swApi(RestTemplate restTemplate) {
		return new SWApi(restTemplate, new ObjectMapper());
	}

}