package com.monster.Monster.Hunter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.monster.Monster.Hunter.persistence.entities.MonstruoHabitat;
import com.monster.Monster.Hunter.service.MonstruoHabitatService;
import com.monster.Monster.Hunter.service.dto.MonstruoHabitatDTO;
import com.monster.Monster.Hunter.web.controller.MonstruoHabitatController;

@ExtendWith(MockitoExtension.class)
public class MonstruoHabitatControllerTest {

    @Mock
    private MonstruoHabitatService monstruohabitatService;

    @InjectMocks
    private MonstruoHabitatController monstruoHabitatController;

    private MonstruoHabitat monstruoHabitat;
    private MonstruoHabitatDTO monstruoHabitatDTO;

    @BeforeEach
    void setUp() {
        monstruoHabitat = new MonstruoHabitat();
        monstruoHabitat.setId(1);

        monstruoHabitatDTO = new MonstruoHabitatDTO();
        monstruoHabitatDTO.setId(1);
    }

    @Test
    void testListarHabitat() {
        // Configura el mock para que findAll devuelva una lista con el DTO de prueba
        when(monstruohabitatService.findAll()).thenReturn(Collections.singletonList(monstruoHabitatDTO));

        // Llama al método listarHabitat del controlador
        ResponseEntity<List<MonstruoHabitatDTO>> response = monstruoHabitatController.listarHabitat();

        // Verifica que la respuesta sea OK y que contenga el DTO
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(1, response.getBody().get(0).getId());
        verify(monstruohabitatService).findAll();
    }

    @Test
    void testGetHabitatById_Exists() {
        // Configura el mock para que existById devuelva true y findById devuelva el DTO
        when(monstruohabitatService.existById(1)).thenReturn(true);
        when(monstruohabitatService.findById(1)).thenReturn(monstruoHabitatDTO);

        // Llama al método getHabitatById del controlador
        ResponseEntity<MonstruoHabitatDTO> response = monstruoHabitatController.getHabitatById(1);

        // Verifica que la respuesta sea OK y que contenga el DTO
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
        verify(monstruohabitatService).existById(1);
        verify(monstruohabitatService).findById(1);
    }

    @Test
    void testGetHabitatById_NotExists() {
        // Configura el mock para que existById devuelva false
        when(monstruohabitatService.existById(1)).thenReturn(false);

        // Llama al método getHabitatById del controlador
        ResponseEntity<MonstruoHabitatDTO> response = monstruoHabitatController.getHabitatById(1);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(monstruohabitatService).existById(1);
    }

    @Test
    void testCrearHabitat() {
        // Configura el mock para que create devuelva el DTO
        when(monstruohabitatService.create(any(MonstruoHabitat.class))).thenReturn(monstruoHabitatDTO);

        // Llama al método crearHabitat del controlador
        ResponseEntity<MonstruoHabitatDTO> response = monstruoHabitatController.crearHabitat(monstruoHabitat);

        // Verifica que la respuesta sea CREATED y que contenga el DTO
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
        verify(monstruohabitatService).create(monstruoHabitat);
    }

    @Test
    void testActualizaHabitat_Success() {
        // Configura el mock para que existById devuelva true y save devuelva el MonstruoHabitat
        monstruoHabitat.setId(1);
        when(monstruohabitatService.existById(1)).thenReturn(true);
        when(monstruohabitatService.save(any(MonstruoHabitat.class))).thenReturn(monstruoHabitat);

        // Llama al método actualizaHabitat del controlador
        ResponseEntity<MonstruoHabitat> response = monstruoHabitatController.actualizaHabitat(1, monstruoHabitat);

        // Verifica que la respuesta sea OK y que contenga el MonstruoHabitat
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
        verify(monstruohabitatService).existById(1);
        verify(monstruohabitatService).save(monstruoHabitat);
    }

    @Test
    void testActualizaHabitat_IdMismatch() {
        // Llama al método actualizaHabitat con ID 1 y MonstruoHabitat con ID 2
        monstruoHabitat.setId(2);
        ResponseEntity<MonstruoHabitat> response = monstruoHabitatController.actualizaHabitat(1, monstruoHabitat);

        // Verifica que la respuesta sea BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testActualizaHabitat_NotExists() {
        // Configura el mock para que existById devuelva false
        monstruoHabitat.setId(1);
        when(monstruohabitatService.existById(1)).thenReturn(false);

        // Llama al método actualizaHabitat del controlador
        ResponseEntity<MonstruoHabitat> response = monstruoHabitatController.actualizaHabitat(1, monstruoHabitat);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(monstruohabitatService).existById(1);
    }

    @Test
    void testEliminarHabitat_Success() {
        // Configura el mock para que borrarId devuelva true
        when(monstruohabitatService.borrarId(1)).thenReturn(true);

        // Llama al método eliminarHabitat del controlador
        ResponseEntity<MonstruoHabitat> response = monstruoHabitatController.eliminarHabitat(1);

        // Verifica que la respuesta sea OK
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(monstruohabitatService).borrarId(1);
    }

    @Test
    void testEliminarHabitat_NotFound() {
        // Configura el mock para que borrarId devuelva false
        when(monstruohabitatService.borrarId(1)).thenReturn(false);

        // Llama al método eliminarHabitat del controlador
        ResponseEntity<MonstruoHabitat> response = monstruoHabitatController.eliminarHabitat(1);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(monstruohabitatService).borrarId(1);
    }
}