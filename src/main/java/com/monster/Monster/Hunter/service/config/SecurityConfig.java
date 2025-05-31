package com.monster.Monster.Hunter.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JWTFilter jwtFilter;

    // Inyección del filtro JWT personalizado
    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    // Configuración principal de la cadena de filtros de seguridad
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())// Desactiva CSRF (útil para APIs REST)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.GET, "/**").permitAll() // Todos los GET públicos
                        .requestMatchers(HttpMethod.POST, "/auth/login", "/auth/register").permitAll() // Login/registro
                                                                                                       // públicos
                        .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN") // POST solo admin
                        .requestMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN") // PUT solo admin
                        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN") // DELETE solo admin
                        .anyRequest().authenticated()// Cualquier otra petición requiere autenticación
                )
                // Añade el filtro JWT antes del filtro de autenticación por usuario/contraseña
                // de Spring
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Declara el filtro JWT como bean (si lo necesitas en otros lugares)
    @Bean
    JWTFilter jwtAuthenticationFilter() {
        return new JWTFilter();
    }

    // Bean para gestionar la autenticación (necesario para login con Spring
    // Security)
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Bean para codificar contraseñas (BCrypt recomendado)
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
