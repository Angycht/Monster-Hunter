package com.monster.Monster.Hunter.service.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.http.HttpMethod;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JWTFilter jwtFilter;

    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
     SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                		.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                		.requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                		    .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
     AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
     PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
