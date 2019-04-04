package br.com.elo7.spacetravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpacetravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpacetravelApplication.class, args);
	}

	@Bean 
	public ObjectMapper objectMapper() {
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		return objMapper;
	}
}
