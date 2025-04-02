package com.monster.Monster.Hunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.Rol;
import com.monster.Monster.Hunter.persistence.entities.Usuario;
import com.monster.Monster.Hunter.persistence.repository.RolRepository;
import com.monster.Monster.Hunter.persistence.repository.UsuarioRepository;

@Configuration
@Service
public class UsuarioSecurityService implements UserDetailsService {

	@Bean
	protected PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException{
		Optional<Usuario> usuario= usuarioRepository.findByCorreo(correo);
		if (usuario.isEmpty()) {
			throw new UsernameNotFoundException ("El usuario no se ha encontrado");
		}
		
		Usuario usuarioBD = usuario.get();
		List<Rol> rolesBD = this.rolRepository.findByIdUsuario(usuarioBD.getId());
				
		String[] roles= new String[rolesBD.size()];
		
		for(int i =0;i<roles.length;i++) {
			roles[i]= rolesBD.get(i).getNombre();
		}
		
		return User.builder()
				.username(correo)
				.password(usuarioBD.getPassword())
				.roles(roles)
				.disabled(false)
				.accountLocked(false)
				.build();
	}
	
}
