package com.monster.Monster.Hunter.service;

import com.monster.Monster.Hunter.persistence.entities.Role;
import com.monster.Monster.Hunter.persistence.entities.User;
import com.monster.Monster.Hunter.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


    /*
     * Método central de Spring Security para cargar detalles del usuario durante la autenticación
     * @param username Nombre de usuario proporcionado en el login
     * @return UserDetails con información requerida para la autenticación/autorización
     * @throws UsernameNotFoundException si el usuario no existe
     */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	// 1. Buscar usuario en la base de datos
		User user = userRepository.findByUsername(username)
    		    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
// 2. Obtener el rol del usuario (convertir nuestra entidad Role a GrantedAuthority)
    		Role role = user.getRole();
			 // 3. Crear lista de autoridades (roles/permissions) para Spring Security
    		List<GrantedAuthority> authorities = List.of(
    			    new SimpleGrantedAuthority("ROLE_" + role.getNombre())
					// Prefijo ROLE_ requerido por Spring
    			);
 // 4. Construir objeto UserDetails con los datos esenciales
    		return new org.springframework.security.core.userdetails.User(
    		    user.getUsername(),
    		    user.getPassword(),
    		    authorities
    		);
    }
}
