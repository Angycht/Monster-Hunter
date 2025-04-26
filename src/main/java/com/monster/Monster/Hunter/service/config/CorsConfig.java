package com.monster.Monster.Hunter.service.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Origen de Angular
	    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
	    config.setAllowedHeaders(Arrays.asList("*"));
	    
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);
	    return source;
	}
}
