package com.monster.Monster.Hunter.service.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//Sin esta configuración, tu navegador bloquearía las peticiones de Angular a Spring Boot por política de seguridad CORS.
@Configuration
public class CorsConfig implements WebMvcConfigurer {
	// Expone el método como un bean de Spring para ser gestionado automáticamente
	@Bean
	 CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration config = new CorsConfiguration();
		 // Permite solicitudes solo desde el origen de tu frontend Angular
	    config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Origen de Angular
		// Permite los métodos HTTP especificados
	    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		 // Permite todos los headers (como Authorization, Content-Type, etc.)
	    config.setAllowedHeaders(Arrays.asList("*"));
	    // Crea la fuente de configuración CORS y la registra para todas las rutas de la API
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);
		 // Devuelve la configuración lista para ser usada por Spring
	    return source;
	}
}
