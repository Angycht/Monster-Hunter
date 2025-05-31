package com.monster.Monster.Hunter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.monster.Monster.Hunter.persistence.entities.Familia;
import com.monster.Monster.Hunter.service.FamiliaService;
import com.monster.Monster.Hunter.service.dto.FamiliaDetalleDTO;
import com.monster.Monster.Hunter.web.controller.FamiliaController;
@ExtendWith(MockitoExtension.class)
public class FamiliaControllerTest {

    @Mock
    private FamiliaService familiaService;

    @InjectMocks
    private FamiliaController familiaController;

    private Familia familia;
    private FamiliaDetalleDTO familiaDetalleDTO;

    @BeforeEach
    void setUp() {
        familia = new Familia();
        familia.setId(1);
        familia.setNombre("Prueba");

        familiaDetalleDTO = new FamiliaDetalleDTO();
        familiaDetalleDTO.setId(1);
        familiaDetalleDTO.setNombre("Prueba");
    }

    @Test
    void testListarFamilias() {
        // Configura el mock para que findAll devuelva una lista con la familia de prueba
        when(familiaService.findAll()).thenReturn(Collections.singletonList(familia));

        // Llama al método listarFamilias del controlador
        ResponseEntity<List<Familia>> response = familiaController.listarFamilias();

        // Verifica que la respuesta sea OK y que contenga la familia
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Prueba", response.getBody().get(0).getNombre());
        verify(familiaService).findAll();
    }

    @Test
    void testGetFamiliaDetalle_Success() {
        // Configura el mock para que getFamiliaDetalle devuelva el DTO de prueba
        when(familiaService.getFamiliaDetalle(1)).thenReturn(familiaDetalleDTO);

        // Llama al método getFamiliaDetalle del controlador
        ResponseEntity<FamiliaDetalleDTO> response = familiaController.getFamiliaDetalle(1);

        // Verifica que la respuesta sea OK y que contenga el DTO
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Prueba", response.getBody().getNombre());
        verify(familiaService).getFamiliaDetalle(1);
    }

    @Test
    void testGetFamiliaDetalle_NotFound() {
        // Configura el mock para que getFamiliaDetalle lance una excepción
        when(familiaService.getFamiliaDetalle(1)).thenThrow(new IllegalArgumentException());

        // Llama al método getFamiliaDetalle del controlador
        ResponseEntity<FamiliaDetalleDTO> response = familiaController.getFamiliaDetalle(1);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(familiaService).getFamiliaDetalle(1);
    }

    @Test
    void testGetFamiliaById_Exists() {
        // Configura el mock para que existById devuelva true y findById devuelva la familia
        when(familiaService.existById(1)).thenReturn(true);
        when(familiaService.findById(1)).thenReturn(Optional.of(familia));

        // Llama al método getFamiliaById del controlador
        ResponseEntity<Familia> response = familiaController.getFamiliaById(1);

        // Verifica que la respuesta sea OK y que contenga la familia
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Prueba", response.getBody().getNombre());
        verify(familiaService).existById(1);
        verify(familiaService).findById(1);
    }

    @Test
    void testGetFamiliaById_NotExists() {
        // Configura el mock para que existById devuelva false
        when(familiaService.existById(1)).thenReturn(false);

        // Llama al método getFamiliaById del controlador
        ResponseEntity<Familia> response = familiaController.getFamiliaById(1);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(familiaService).existById(1);
    }

    @Test
    void testCrearFamilia() {
        // Configura el mock para que create devuelva la familia
        when(familiaService.create(any(Familia.class))).thenReturn(familia);

        // Llama al método crearFamilia del controlador
        ResponseEntity<Familia> response = familiaController.crearFamilia(familia);

        // Verifica que la respuesta sea CREATED y que contenga la familia
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Prueba", response.getBody().getNombre());
        verify(familiaService).create(familia);
    }

    @Test
    void testActualizarFamilia_Success() {
        // Configura el mock para que existById devuelva true y save devuelva la familia
        familia.setId(1);
        when(familiaService.existById(1)).thenReturn(true);
        when(familiaService.save(any(Familia.class))).thenReturn(familia);

        // Llama al método actualizarFamilia del controlador
        ResponseEntity<Familia> response = familiaController.actualizarFamilia(1, familia);

        // Verifica que la respuesta sea OK y que contenga la familia
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Prueba", response.getBody().getNombre());
        verify(familiaService).existById(1);
        verify(familiaService).save(familia);
    }

    @Test
    void testActualizarFamilia_IdMismatch() {
        // Llama al método actualizarFamilia con ID 1 y familia con ID 2
        familia.setId(2);
        ResponseEntity<Familia> response = familiaController.actualizarFamilia(1, familia);

        // Verifica que la respuesta sea BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testActualizarFamilia_NotExists() {
        // Configura el mock para que existById devuelva false
        familia.setId(1);
        when(familiaService.existById(1)).thenReturn(false);

        // Llama al método actualizarFamilia del controlador
        ResponseEntity<Familia> response = familiaController.actualizarFamilia(1, familia);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(familiaService).existById(1);
    }

    @Test
    void testEliminarFamilia_Success() {
        // Configura el mock para que borrarId devuelva true
        when(familiaService.borrarId(1)).thenReturn(true);

        // Llama al método eliminarFamilia del controlador
        ResponseEntity<Familia> response = familiaController.eliminarFamilia(1);

        // Verifica que la respuesta sea OK
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(familiaService).borrarId(1);
    }

    @Test
    void testEliminarFamilia_NotFound() {
        // Configura el mock para que borrarId devuelva false
        when(familiaService.borrarId(1)).thenReturn(false);

        // Llama al método eliminarFamilia del controlador
        ResponseEntity<Familia> response = familiaController.eliminarFamilia(1);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(familiaService).borrarId(1);
    }

    @Test
    void testBuscar() {
        // Configura el mock para que empiezaPor devuelva una lista con la familia
        when(familiaService.empiezaPor(anyString())).thenReturn(Collections.singletonList(familia));

        // Llama al método buscar del controlador
        ResponseEntity<List<Familia>> response = familiaController.buscar("Prueba");

        // Verifica que la respuesta sea OK y que contenga la familia
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Prueba", response.getBody().get(0).getNombre());
        verify(familiaService).empiezaPor("Prueba");
    }
}