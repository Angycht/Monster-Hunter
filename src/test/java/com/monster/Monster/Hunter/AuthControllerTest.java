package com.monster.Monster.Hunter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.monster.Monster.Hunter.persistence.entities.RegistroRequest;
import com.monster.Monster.Hunter.persistence.entities.Role;
import com.monster.Monster.Hunter.persistence.entities.User;
import com.monster.Monster.Hunter.persistence.repository.RoleRepository;
import com.monster.Monster.Hunter.persistence.repository.UserRepository;
import com.monster.Monster.Hunter.service.util.JwtTokenUtil;
import com.monster.Monster.Hunter.web.controller.AuthController;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    // Mocks de los repositorios y servicios que usa el controlador
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtTokenUtil jwtTokenUtil;
    @Mock
    private PasswordEncoder passwordEncoder;

    // Controlador bajo test, inyectado con los mocks
    @InjectMocks
    private AuthController authController;

    // Datos de prueba para los tests
    private User user;
    private Role role;
    private RegistroRequest loginRequest;

    // Método ejecutado antes de cada test para inicializar los datos de prueba
    @BeforeEach
    void setUp() {
        // Crea un rol de prueba
        role = new Role();
        role.setId(3);
        role.setNombre("USER");

        // Crea un usuario de prueba
        user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        user.setRole(role);

        // Crea una petición de login de prueba
        loginRequest = new RegistroRequest();
        loginRequest.setUsername("testuser");
        loginRequest.setPassword("password");
    }

    // Test para el método login cuando las credenciales son correctas
    @Test
    void testLogin_Success() {
        // Configura el mock para que authenticationManager.authenticate funcione
    	when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
        .thenReturn(null);        // Configura el mock para que userRepository.findByUsername devuelva el usuario de prueba
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(user));
        // Configura el mock para que jwtTokenUtil.generateToken devuelva un token de prueba
        when(jwtTokenUtil.generateToken(anyString(), anyString())).thenReturn("token_prueba");

        // Llama al método login del controlador
        ResponseEntity<?> response = authController.login(loginRequest);

        // Verifica que la respuesta sea OK (200) y que contenga el token
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("token_prueba", response.getBody());
        // Verifica que se haya llamado a authenticationManager.authenticate con las credenciales correctas
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        // Verifica que se haya llamado a userRepository.findByUsername con el nombre de usuario correcto
        verify(userRepository).findByUsername("testuser");
        // Verifica que se haya llamado a jwtTokenUtil.generateToken con el nombre de usuario y el rol correctos
        verify(jwtTokenUtil).generateToken("testuser", "USER");
    }

    // Test para el método login cuando las credenciales son incorrectas
    @Test
    void testLogin_Failure() {
        // Configura el mock para que authenticationManager.authenticate lance una excepción
        doThrow(new BadCredentialsException("Credenciales inválidas"))
            .when(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));

        // Llama al método login del controlador
        ResponseEntity<?> response = authController.login(loginRequest);

        // Verifica que la respuesta sea UNAUTHORIZED (401) y que contenga el mensaje de error
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Credenciales inválidas", response.getBody());
        // Verifica que se haya llamado a authenticationManager.authenticate con las credenciales correctas
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
    }

    // Test para el método login cuando el usuario no existe
    @Test
    void testLogin_UserNotFound() {
    	when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
    	// Simula que la autenticación funciona (opcional, según tu lógica)
    	when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
    	    .thenReturn(mock(Authentication.class));

    	ResponseEntity<?> response = authController.login(loginRequest);

    	assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    	assertEquals("Credenciales inválidas", response.getBody());
    }

    // Test para el método register cuando el registro es exitoso
    @Test
    void testRegister_Success() {
        // Configura el mock de PasswordEncoder
        when(passwordEncoder.encode(anyString())).thenReturn("password_encriptada");
        // Configura el mock de RoleRepository
        when(roleRepository.findById(3)).thenReturn(Optional.of(role));
        // Configura el mock de UserRepository
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Llama al método register del controlador
        ResponseEntity<String> response = authController.register(user);

        // Verifica la respuesta
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Usuario registrado exitosamente", response.getBody());
        verify(passwordEncoder).encode("password");
        verify(roleRepository).findById(3);
        verify(userRepository).save(user);
    }
    // Test para el método register cuando el rol no existe
    @Test
    void testRegister_RoleNotFound() {
        // Configura el mock para que passwordEncoder.encode devuelva una contraseña encriptada
        when(passwordEncoder.encode(anyString())).thenReturn("password_encriptada");
        // Configura el mock para que roleRepository.findById devuelva un Optional vacío
        when(roleRepository.findById(3)).thenReturn(Optional.empty());

        // Llama al método register del controlador y verifica que lance RuntimeException
        assertThrows(RuntimeException.class, () -> authController.register(user));
        // Verifica que se haya llamado a passwordEncoder.encode con la contraseña correcta
        verify(passwordEncoder).encode("password");
        // Verifica que se haya llamado a roleRepository.findById con el ID correcto
        verify(roleRepository).findById(3);
    }
}