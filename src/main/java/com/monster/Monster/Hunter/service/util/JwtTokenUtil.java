package com.monster.Monster.Hunter.service.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
// Indica que esta clase será gestionada como un componente de Spring
@Component
public class JwtTokenUtil {
 // Clave secreta para firmar y verificar los JWT (algoritmo HS256)
	private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
 // Tiempo de expiración del token (10 horas en milisegundos)
	private final long jwtExpirationMs = 1000 * 60 * 60 * 10;
  /**
     * Genera un JWT para el usuario dado, incluyendo el rol como claim.
     *Nombre de usuario
     *Rol del usuario (ej: "ADMIN", "USER")
     * JWT firmado como String
     */
	public String generateToken(String username, String role) { // Añade parámetro de rol
		return Jwts.builder().setSubject(username).claim("role", role) // Asigna el usuario como sujeto del token
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))// Fecha de emisión y de expiracion
				.signWith(secretKey).compact(); // Firma el token con la clave secreta
	}

	// Método para obtener el rol del token
	public String getRoleFromToken(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
		return claims.get("role", String.class);
	}
/**
     * Valida si el token es correcto y no está expirado.
     * JWT recibido
     *  true si es válido, false si es inválido o expirado
     */
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
/**
     * Extrae el nombre de usuario (subject) del JWT.
     *JWT recibido
     *Nombre de usuario
     */
	public String getUsernameFromToken(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
}
