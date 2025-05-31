package com.monster.Monster.Hunter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.monster.Monster.Hunter.persistence.entities.Monstruo;
import com.monster.Monster.Hunter.service.MonstruoService;
import com.monster.Monster.Hunter.service.dto.MonstruoMaterialDTO;
import com.monster.Monster.Hunter.web.controller.MonstruoController;

class MonstruoControllerTest {
    // @Mock: Crea un mock del servicio MonstruoService para simular su comportamiento
    @Mock
    private MonstruoService monstruoService;
    
    // @InjectMocks: Inyecta el mock del servicio en el controlador MonstruoController
    @InjectMocks
    private MonstruoController monstruoController;
    
    // @BeforeEach: Método que se ejecuta antes de cada test para inicializar los mocks
    @BeforeEach
    void setUp() throws Exception {
        // Inicializa los mocks anotados (@Mock, @InjectMocks)
        MockitoAnnotations.openMocks(this);
    }

    // @Test: Indica que este método es un test
    @Test
    void testListarMonstruos() {
        // Verifica que listarMonstruos no lance excepciones
        assertDoesNotThrow(() -> monstruoController.listarMonstruos());
        // Verifica que el método findAll del servicio haya sido llamado
        verify(monstruoService).findAll();
    }

    // @Test: Indica que este método es un test
    @Test
    void testGetMonstruoById_exists() {
        // Configura el mock para que existById devuelva true para cualquier entero
        when(monstruoService.existById(Mockito.anyInt())).thenReturn(true);
        // Verifica que getMonstruoById no lance excepciones
        assertDoesNotThrow(() -> monstruoController.getMonstruoById(1));
        // Verifica que el método findById del servicio haya sido llamado con ID 1
        verify(monstruoService).findById(1);
    }

    // @Test: Indica que este método es un test
    @Test
    void testGetMonstruoById_notExists() {
        // Configura el mock para que existById devuelva false para cualquier entero
        when(monstruoService.existById(Mockito.anyInt())).thenReturn(false);
        // Verifica que getMonstruoById no lance excepciones
        assertDoesNotThrow(() -> monstruoController.getMonstruoById(1));
    }

    // @Test: Indica que este método es un test
    @Test
    void testCrearMonstruo() {
        // Crea un nuevo monstruo para el test
        Monstruo newMonster = new Monstruo();
        // Verifica que crearMonstruo no lance excepciones
        assertDoesNotThrow(() -> monstruoController.crearMonstruo(newMonster));
        // Verifica que el método create del servicio haya sido llamado con el monstruo creado
        verify(monstruoService).create(newMonster);
    }

    // @Test: Indica que este método es un test
    @Test
    void testActualizarMonstruo_notID() {
        // Crea un monstruo y le asigna el ID 2
        Monstruo monster = new Monstruo();
        monster.setId(2);
        // Verifica que actualizarMonstruo no lance excepciones cuando el ID de la ruta no coincide con el del monstruo
        assertDoesNotThrow(() -> monstruoController.actualizarMonstruo(1, monster));
    }

    // @Test: Indica que este método es un test
    @Test
    void testActualizarMonstruo() {
        // Crea un monstruo y le asigna el ID 2
        Monstruo monster = new Monstruo();
        monster.setId(2);
        // Configura el mock para que existById devuelva true para cualquier entero
        when(monstruoService.existById(Mockito.anyInt())).thenReturn(true);
        // Verifica que actualizarMonstruo no lance excepciones
        assertDoesNotThrow(() -> monstruoController.actualizarMonstruo(2, monster));
        // Verifica que el método save del servicio haya sido llamado con el monstruo creado
        verify(monstruoService).save(monster);
    }

    // @Test: Indica que este método es un test
    @Test
    void testActualizarMonstruo_notExists() {
        // Crea un monstruo y le asigna el ID 2
        Monstruo monster = new Monstruo();
        monster.setId(2);
        // Configura el mock para que existById devuelva false para cualquier entero
        when(monstruoService.existById(Mockito.anyInt())).thenReturn(false);
        // Verifica que actualizarMonstruo no lance excepciones
        assertDoesNotThrow(() -> monstruoController.actualizarMonstruo(2, monster));
    }

    // @Test: Indica que este método es un test
    @Test
    void testEliminarMonstruo_Success() {
        // Configura el mock para que borrarId devuelva true con ID 1
        when(monstruoService.borrarId(1)).thenReturn(true);
        // Llama al método eliminarMonstruo del controlador con ID 1 y guarda la respuesta
        ResponseEntity<Monstruo> response = monstruoController.eliminarMonstruo(1);
        // Verifica que el código de estado de la respuesta sea OK (200)
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Verifica que el método borrarId del servicio haya sido llamado con ID 1
        verify(monstruoService).borrarId(1);
    }

    // @Test: Indica que este método es un test
    @Test
    void testEliminarMonstruo_NotFound() {
        // Configura el mock para que borrarId devuelva false con ID 1
        when(monstruoService.borrarId(1)).thenReturn(false);
        // Llama al método eliminarMonstruo del controlador con ID 1 y guarda la respuesta
        ResponseEntity<Monstruo> response = monstruoController.eliminarMonstruo(1);
        // Verifica que el código de estado de la respuesta sea NOT_FOUND (404)
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        // Verifica que el método borrarId del servicio haya sido llamado con ID 1
        verify(monstruoService).borrarId(1);
    }

    // @Test: Indica que este método es un test
    @Test
    void testBuscar() {
        // Crea un monstruo para el test
        Monstruo monstruo = new Monstruo();
        // Configura el mock para que empiezaPor devuelva una lista con el monstruo creado
        when(monstruoService.empiezaPor(anyString())).thenReturn(Collections.singletonList(monstruo));
        // Llama al método buscar del controlador con el nombre "Rath" y guarda la respuesta
        ResponseEntity<List<Monstruo>> response = monstruoController.buscar("Rath");
        // Verifica que el código de estado de la respuesta sea OK (200)
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Verifica que la lista de monstruos tenga exactamente 1 elemento
        assertEquals(1, response.getBody().size());
        // Verifica que el método empiezaPor del servicio haya sido llamado con "Rath"
        verify(monstruoService).empiezaPor("Rath");
    }

    // @Test: Indica que este método es un test
    @Test
    void testSimularCombate() {
        // Crea un objeto MonstruoMaterialDTO para simular el resultado del combate
        MonstruoMaterialDTO materialDTO = new MonstruoMaterialDTO();
        // Asigna un ID al material
        materialDTO.setId(1);
        // Asigna una imagen al material
        materialDTO.setImagen("prueba");
        // Asigna un nombre al material
        materialDTO.setNombre("prueba");
        // Asigna un nombre de monstruo al material (opcional, según tu modelo)
        materialDTO.setNombreMonstruo("Prueba");
        // Asigna una probabilidad al material (opcional, según tu modelo)
        materialDTO.setProbabilidad(3);
        // Configura el mock para que, cuando se llame a simularCombate con cualquier entero, devuelva una lista con el materialDTO creado
        when(monstruoService.simularCombate(anyInt())).thenReturn(Collections.singletonList(materialDTO));
        // Llama al método simularCombate del controlador con ID 1 y guarda la respuesta
        ResponseEntity<List<MonstruoMaterialDTO>> response = monstruoController.simularCombate(1);
        // Verifica que el código de estado de la respuesta sea OK (200)
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Verifica que la lista de materiales tenga exactamente 1 elemento
        assertEquals(1, response.getBody().size());
        // Verifica que el nombre del primer material sea "prueba"
        assertEquals("prueba", response.getBody().get(0).getNombre());
        // Verifica que el método simularCombate del servicio haya sido llamado con ID 1
        verify(monstruoService).simularCombate(1);
    }
}