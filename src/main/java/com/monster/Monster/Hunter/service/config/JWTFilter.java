package com.monster.Monster.Hunter.service.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.monster.Monster.Hunter.service.util.JwtTokenUtil;

import java.io.IOException;

// Este filtro es el núcleo de la seguridad JWT en tu aplicación: garantiza que solo los usuarios autenticados y autorizados puedan acceder a los recursos protegidos.
@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    // Utilidad para validar y extraer datos del JWT
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    // Servicio para cargar detalles del usuario
    private com.monster.Monster.Hunter.service.CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("Path recibido: " + request.getServletPath());

        // EXCLUIR login y register del filtro JWT (no requieren autenticación)
        if (path.equals("/auth/login") || path.equals("/auth/register")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Obtener el header Authorization
        final String authHeader = request.getHeader("Authorization");
        // Si no existe o no empieza por "Bearer ", continuar sin autenticar
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        // Extraer el token JWT del header
        final String token = authHeader.substring(7);
        // Validar el token; si no es válido, continuar sin autenticar
        if (!jwtTokenUtil.validateToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        // Extraer el username del token
        String username = jwtTokenUtil.getUsernameFromToken(token);
        // Cargar los detalles del usuario desde la base de datos
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        System.out.println("Authorities del usuario " + username + ": " + userDetails.getAuthorities());
        // Crear el objeto de autenticación para el contexto de seguridad de Spring
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // Guardar la autenticación en el contexto de seguridad
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Continuar con la cadena de filtros
        filterChain.doFilter(request, response);

    }
}
