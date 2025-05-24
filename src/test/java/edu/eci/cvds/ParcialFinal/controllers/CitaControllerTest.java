package edu.eci.cvds.ParcialFinal.controllers;

import edu.eci.cvds.ParcialFinal.modules.Cita;
import edu.eci.cvds.ParcialFinal.services.CitaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CitaControllerTest {

    @InjectMocks
    private CitaController citaController;

    @Mock
    private CitaService citaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void programarCita_DeberiaRetornarCitaConfirmada() {
        Cita cita = new Cita();
        cita.setFecha(LocalDate.now().plusDays(1));

        Cita citaGuardada = new Cita();
        citaGuardada.setFecha(cita.getFecha());
        citaGuardada.setEstado("Confirmada");

        when(citaService.programarCita(any(Cita.class))).thenReturn(citaGuardada);

        ResponseEntity<Cita> response = citaController.programarCita(cita);

        assertNotNull(response);
        assertEquals("Confirmada", response.getBody().getEstado());
        verify(citaService, times(1)).programarCita(cita);
    }

    @Test
    void obtenerCitasPorCorreo_DeberiaRetornarLista() {
        String correo = "test@correo.com";

        when(citaService.obtenerCitasPorCorreo(correo)).thenReturn(List.of(new Cita(), new Cita()));

        ResponseEntity<List<Cita>> response = citaController.obtenerCitasPorCorreo(correo);

        assertNotNull(response);
        assertEquals(2, response.getBody().size());
        verify(citaService, times(1)).obtenerCitasPorCorreo(correo);
    }


}
