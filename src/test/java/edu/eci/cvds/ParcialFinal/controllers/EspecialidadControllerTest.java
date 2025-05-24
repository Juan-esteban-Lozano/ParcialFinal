package edu.eci.cvds.ParcialFinal.controllers;

import edu.eci.cvds.ParcialFinal.modules.Especialidad;
import edu.eci.cvds.ParcialFinal.repositories.EspecialidadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EspecialidadControllerTest {

    @InjectMocks
    private EspecialidadController especialidadController;

    @Mock
    private EspecialidadRepository especialidadRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerEspecialidades_DeberiaRetornarLista() {
        when(especialidadRepository.findAll()).thenReturn(List.of(new Especialidad(), new Especialidad()));

        List<Especialidad> resultado = especialidadController.obtenerEspecialidades();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(especialidadRepository, times(1)).findAll();
    }
}
