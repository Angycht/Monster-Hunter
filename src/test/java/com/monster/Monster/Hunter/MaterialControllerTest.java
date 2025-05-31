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
import com.monster.Monster.Hunter.persistence.entities.Material;
import com.monster.Monster.Hunter.service.MaterialService;
import com.monster.Monster.Hunter.web.controller.MaterialController;

@ExtendWith(MockitoExtension.class)
public class MaterialControllerTest {

    @Mock
    private MaterialService materialService;

    @InjectMocks
    private MaterialController materialController;

    private Material material;

    @BeforeEach
    void setUp() {
        material = new Material();
        material.setId(1);
        material.setNombre("Prueba");
    }

    @Test
    void testListarMaterial() {
        // Configura el mock para que findAll devuelva una lista con el material de prueba
        when(materialService.findAll()).thenReturn(Collections.singletonList(material));

        // Llama al método listarMaterial del controlador
        ResponseEntity<List<Material>> response = materialController.listarMaterial();

        // Verifica que la respuesta sea OK y que contenga el material
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Prueba", response.getBody().get(0).getNombre());
        verify(materialService).findAll();
    }

    @Test
    void testGetMaterialById_Exists() {
        // Configura el mock para que existById devuelva true y findById devuelva el material
        when(materialService.existById(1)).thenReturn(true);
        when(materialService.findById(1)).thenReturn(Optional.of(material));

        // Llama al método getMaterialById del controlador
        ResponseEntity<Material> response = materialController.getMaterialById(1);

        // Verifica que la respuesta sea OK y que contenga el material
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Prueba", response.getBody().getNombre());
        verify(materialService).existById(1);
        verify(materialService).findById(1);
    }

    @Test
    void testGetMaterialById_NotExists() {
        // Configura el mock para que existById devuelva false
        when(materialService.existById(1)).thenReturn(false);

        // Llama al método getMaterialById del controlador
        ResponseEntity<Material> response = materialController.getMaterialById(1);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(materialService).existById(1);
    }

    @Test
    void testCrearMaterial() {
        // Configura el mock para que create devuelva el material
        when(materialService.create(any(Material.class))).thenReturn(material);

        // Llama al método crearMaterial del controlador
        ResponseEntity<Material> response = materialController.crearMaterial(material);

        // Verifica que la respuesta sea CREATED y que contenga el material
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Prueba", response.getBody().getNombre());
        verify(materialService).create(material);
    }

    @Test
    void testActualizarMaterial_Success() {
        // Configura el mock para que existById devuelva true y save devuelva el material
        material.setId(1);
        when(materialService.existById(1)).thenReturn(true);
        when(materialService.save(any(Material.class))).thenReturn(material);

        // Llama al método actualizarMaterial del controlador
        ResponseEntity<Material> response = materialController.actualizarMaterial(1, material);

        // Verifica que la respuesta sea OK y que contenga el material
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Prueba", response.getBody().getNombre());
        verify(materialService).existById(1);
        verify(materialService).save(material);
    }

    @Test
    void testActualizarMaterial_IdMismatch() {
        // Llama al método actualizarMaterial con ID 1 y material con ID 2
        material.setId(2);
        ResponseEntity<Material> response = materialController.actualizarMaterial(1, material);

        // Verifica que la respuesta sea BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testActualizarMaterial_NotExists() {
        // Configura el mock para que existById devuelva false
        material.setId(1);
        when(materialService.existById(1)).thenReturn(false);

        // Llama al método actualizarMaterial del controlador
        ResponseEntity<Material> response = materialController.actualizarMaterial(1, material);

        // Verifica que la respuesta sea NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(materialService).existById(1);
    }

    @Test
    void testEliminarMaterial_Success() {
        // Configura el mock para que borrarId devuelva true
        when(materialService.borrarId(1)).thenReturn(true);

        // Llama al método eliminarMaterial del controlador
        ResponseEntity<Familia> response = materialController.eliminarMaterial(1);

        // Verifica que la respuesta sea OK (aunque devuelve ResponseEntity<Familia>, revisa si es correcto)
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(materialService).borrarId(1);
    }

    @Test
    void testEliminarMaterial_NotFound() {
        // Configura el mock para que borrarId devuelva false
        when(materialService.borrarId(1)).thenReturn(false);

        // Llama al método eliminarMaterial del controlador
        ResponseEntity<Familia> response = materialController.eliminarMaterial(1);

        // Verifica que la respuesta sea NOT_FOUND (aunque devuelve ResponseEntity<Familia>, revisa si es correcto)
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(materialService).borrarId(1);
    }

    @Test
    void testBuscar() {
        // Configura el mock para que empiezaPor devuelva una lista con el material
        when(materialService.empiezaPor(anyString())).thenReturn(Collections.singletonList(material));

        // Llama al método buscar del controlador
        ResponseEntity<List<Material>> response = materialController.buscar("Prueba");

        // Verifica que la respuesta sea OK y que contenga el material
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Prueba", response.getBody().get(0).getNombre());
        verify(materialService).empiezaPor("Prueba");
    }
}