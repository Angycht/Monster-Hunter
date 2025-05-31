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

import com.monster.Monster.Hunter.persistence.entities.Habitat;
import com.monster.Monster.Hunter.persistence.entities.Monstruo;
import com.monster.Monster.Hunter.persistence.entities.MonstruoHabitat;
import com.monster.Monster.Hunter.service.HabitatService;
import com.monster.Monster.Hunter.service.dto.MonstruoDTO;
import com.monster.Monster.Hunter.web.controller.HabitatController;

@ExtendWith(MockitoExtension.class)
public class HabitatControllerTest {

    @Mock
    private HabitatService habitatService;

    @InjectMocks
    private HabitatController habitatController;

    private Habitat habitat;
    private Monstruo monstruo;
    private MonstruoHabitat monstruoHabitat;

    @BeforeEach
    void setUp() {
        habitat = new Habitat();
        habitat.setId(1);
        habitat.setNombre("Prueba");

        monstruo = new Monstruo();
        monstruo.setId(1);
        monstruo.setNombre("MonstruoPrueba");

        monstruoHabitat = new MonstruoHabitat();
        monstruoHabitat.setMonstruo(monstruo);
        monstruoHabitat.setHabitat(habitat);

        habitat.setMonstruoHabitats(Collections.singletonList(monstruoHabitat));
    }

    @Test
    void testListarHabitat() {
        when(habitatService.findAll()).thenReturn(Collections.singletonList(habitat));

        ResponseEntity<List<Habitat>> response = habitatController.listarHabitat();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Prueba", response.getBody().get(0).getNombre());
        verify(habitatService).findAll();
    }

    @Test
    void testGetMonstruosByHabitat_Success() {
    	when(habitatService.buscarMonstruo(1)).thenReturn(Optional.of(Collections.singletonList(habitat)));

        ResponseEntity<List<MonstruoDTO>> response = habitatController.getMonstruosByHabitat(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(1, response.getBody().get(0).getId());
        assertEquals("MonstruoPrueba", response.getBody().get(0).getNombre());
        verify(habitatService).buscarMonstruo(1);
    }

    @Test
    void testGetMonstruosByHabitat_NotFound() {
        when(habitatService.buscarMonstruo(1)).thenReturn(Optional.empty());

        ResponseEntity<List<MonstruoDTO>> response = habitatController.getMonstruosByHabitat(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(habitatService).buscarMonstruo(1);
    }

    @Test
    void testGetHabitatById_Exists() {
        when(habitatService.existById(1)).thenReturn(true);
        when(habitatService.findById(1)).thenReturn(Optional.of(habitat));

        ResponseEntity<Habitat> response = habitatController.getHabitatById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Prueba", response.getBody().getNombre());
        verify(habitatService).existById(1);
        verify(habitatService).findById(1);
    }

    @Test
    void testGetHabitatById_NotExists() {
        when(habitatService.existById(1)).thenReturn(false);

        ResponseEntity<Habitat> response = habitatController.getHabitatById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(habitatService).existById(1);
    }

    @Test
    void testCrearHabitat() {
        when(habitatService.create(any(Habitat.class))).thenReturn(habitat);

        ResponseEntity<Habitat> response = habitatController.crearHabitat(habitat);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Prueba", response.getBody().getNombre());
        verify(habitatService).create(habitat);
    }

    @Test
    void testActualizaHabitat_Success() {
        habitat.setId(1);
        when(habitatService.existById(1)).thenReturn(true);
        when(habitatService.save(any(Habitat.class))).thenReturn(habitat);

        ResponseEntity<Habitat> response = habitatController.actualizaHabitat(1, habitat);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Prueba", response.getBody().getNombre());
        verify(habitatService).existById(1);
        verify(habitatService).save(habitat);
    }

    @Test
    void testActualizaHabitat_IdMismatch() {
        habitat.setId(2);
        ResponseEntity<Habitat> response = habitatController.actualizaHabitat(1, habitat);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testActualizaHabitat_NotExists() {
        habitat.setId(1);
        when(habitatService.existById(1)).thenReturn(false);

        ResponseEntity<Habitat> response = habitatController.actualizaHabitat(1, habitat);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(habitatService).existById(1);
    }

    @Test
    void testEliminarHabitat_Success() {
        when(habitatService.borrarId(1)).thenReturn(true);

        ResponseEntity<Habitat> response = habitatController.eliminarHabitat(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(habitatService).borrarId(1);
    }

    @Test
    void testEliminarHabitat_NotFound() {
        when(habitatService.borrarId(1)).thenReturn(false);

        ResponseEntity<Habitat> response = habitatController.eliminarHabitat(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(habitatService).borrarId(1);
    }

    @Test
    void testBuscar() {
        when(habitatService.empiezaPor(anyString())).thenReturn(Collections.singletonList(habitat));

        ResponseEntity<List<Habitat>> response = habitatController.buscar("Prueba");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Prueba", response.getBody().get(0).getNombre());
        verify(habitatService).empiezaPor("Prueba");
    }
}