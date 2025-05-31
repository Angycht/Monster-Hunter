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

import com.monster.Monster.Hunter.persistence.entities.MonstruoMaterial;
import com.monster.Monster.Hunter.service.MonstruoMaterialService;
import com.monster.Monster.Hunter.service.dto.MonstruoMaterialDTO;
import com.monster.Monster.Hunter.web.controller.MonstruoMaterialController;

@ExtendWith(MockitoExtension.class)
public class MonstruoMaterialControllerTest {

    @Mock
    private MonstruoMaterialService monstruoMaterialService;

    @InjectMocks
    private MonstruoMaterialController monstruoMaterialController;

    private MonstruoMaterial monstruoMaterial;
    private MonstruoMaterialDTO monstruoMaterialDTO;

    @BeforeEach
    void setUp() {
        monstruoMaterial = new MonstruoMaterial();
        monstruoMaterial.setId(1);

        monstruoMaterialDTO = new MonstruoMaterialDTO();
        monstruoMaterialDTO.setId(1);
    }

    @Test
    void testListarMonstruoMaterial() {
        // Configura el mock para que findAll devuelva una lista con el DTO de prueba
        when(monstruoMaterialService.findAll()).thenReturn(Collections.singletonList(monstruoMaterialDTO));

        // Llama al método listarMonstruoMaterial del controlador
        ResponseEntity<List<MonstruoMaterialDTO>> response = monstruoMaterialController.listarMonstruoMaterial();

        // Verifica que la respuesta sea OK y que contenga el DTO
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(1, response.getBody().get(0).getId());
        verify(monstruoMaterialService).findAll();
    }

    @Test
    void testGetMonstruoMaterialById_Exists() {
        // Configura el mock para que existById devuelva true y findById devuelva el DTO
        when(monstruoMaterialService.existById(1)).thenReturn(true);
        when(monstruoMaterialService.findById(1)).thenReturn(monstruoMaterialDTO);

        // Llama al método getMonstruoMaterialById del controlador
        ResponseEntity<MonstruoMaterialDTO> response = monstruoMaterialController.getMonstruoMaterialById(1);

        // Verifica que la respuesta sea OK y que contenga el DTO
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
        verify(monstruoMaterialService).existById(1);
        verify(monstruoMaterialService).findById(1);
    }

    @Test
    void testGetMonstruoMaterialById_NotExists() {
        // Configura el mock para que existById devuelva false
        when(monstruoMaterialService.existById(1)).thenReturn(false);

        // Llama al método getMonstruoMaterialById del controlador
        ResponseEntity<MonstruoMaterialDTO> response = monstruoMaterialController.getMonstruoMaterialById(1);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(monstruoMaterialService).existById(1);
    }

    @Test
    void testCrearMonstruoMaterial() {
        // Configura el mock para que create devuelva el DTO
        when(monstruoMaterialService.create(any(MonstruoMaterial.class))).thenReturn(monstruoMaterialDTO);

        // Llama al método crearMonstruoMaterial del controlador
        ResponseEntity<MonstruoMaterialDTO> response = monstruoMaterialController.crearMonstruoMaterial(monstruoMaterial);

        // Verifica que la respuesta sea CREATED y que contenga el DTO
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
        verify(monstruoMaterialService).create(monstruoMaterial);
    }

    @Test
    void testActualizarMonstruoMaterial_Success() {
        // Configura el mock para que existById devuelva true y save devuelva el MonstruoMaterial
        monstruoMaterial.setId(1);
        when(monstruoMaterialService.existById(1)).thenReturn(true);
        when(monstruoMaterialService.save(any(MonstruoMaterial.class))).thenReturn(monstruoMaterial);

        // Llama al método actualizarMonstruoMaterial del controlador
        ResponseEntity<MonstruoMaterial> response = monstruoMaterialController.actualizarMonstruoMaterial(1, monstruoMaterial);

        // Verifica que la respuesta sea OK y que contenga el MonstruoMaterial
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
        verify(monstruoMaterialService).existById(1);
        verify(monstruoMaterialService).save(monstruoMaterial);
    }

    @Test
    void testActualizarMonstruoMaterial_IdMismatch() {
        // Llama al método actualizarMonstruoMaterial con ID 1 y MonstruoMaterial con ID 2
        monstruoMaterial.setId(2);
        ResponseEntity<MonstruoMaterial> response = monstruoMaterialController.actualizarMonstruoMaterial(1, monstruoMaterial);

        // Verifica que la respuesta sea BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testActualizarMonstruoMaterial_NotExists() {
        // Configura el mock para que existById devuelva false
        monstruoMaterial.setId(1);
        when(monstruoMaterialService.existById(1)).thenReturn(false);

        // Llama al método actualizarMonstruoMaterial del controlador
        ResponseEntity<MonstruoMaterial> response = monstruoMaterialController.actualizarMonstruoMaterial(1, monstruoMaterial);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(monstruoMaterialService).existById(1);
    }

    @Test
    void testEliminarMonstruoMaterial_Success() {
        // Configura el mock para que borrarId devuelva true
        when(monstruoMaterialService.borrarId(1)).thenReturn(true);

        // Llama al método eliminarMonstruoMaterial del controlador
        ResponseEntity<MonstruoMaterial> response = monstruoMaterialController.eliminarMonstruoMaterial(1);

        // Verifica que la respuesta sea OK
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(monstruoMaterialService).borrarId(1);
    }

    @Test
    void testEliminarMonstruoMaterial_NotFound() {
        // Configura el mock para que borrarId devuelva false
        when(monstruoMaterialService.borrarId(1)).thenReturn(false);

        // Llama al método eliminarMonstruoMaterial del controlador
        ResponseEntity<MonstruoMaterial> response = monstruoMaterialController.eliminarMonstruoMaterial(1);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(monstruoMaterialService).borrarId(1);
    }
}