package edu.eci.cvds.ParcialFinal.services;

import edu.eci.cvds.ParcialFinal.modules.Cita;
import edu.eci.cvds.ParcialFinal.repositories.CitaRepository;
import edu.eci.cvds.ParcialFinal.repositories.UsuarioRepository;
import edu.eci.cvds.ParcialFinal.repositories.EspecialidadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CitaServiceTest {

    @InjectMocks
    private CitaService citaService;

    @Mock
    private CitaRepository citaRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private EspecialidadRepository especialidadRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProgramarCitaRechazadaPorFechaInvalida() {
        Cita cita = new Cita();
        cita.setFecha(LocalDate.now().minusDays(1));

        when(citaRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Cita resultado = citaService.programarCita(cita);
        assertEquals("Rechazada", resultado.getEstado());
    }

    @Test
    void testProgramarCitaConfirmada() {
        Cita cita = new Cita();
        cita.setFecha(LocalDate.now().plusDays(1));

        when(citaRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Cita resultado = citaService.programarCita(cita);
        assertEquals("Confirmada", resultado.getEstado());
    }

    @Test
    void testObtenerCitasPorCorreo() {
        String correo = "usuario@correo.com";
        List<Cita> citasMock = List.of(new Cita(), new Cita());

        when(citaRepository.findByUsuarioCorreo(correo)).thenReturn(citasMock);

        List<Cita> resultado = citaService.obtenerCitasPorCorreo(correo);
        assertEquals(2, resultado.size());
    }

    @Test
    void testFiltrarCitasPorEstado() {
        String correo = "usuario@correo.com";
        String estado = "Confirmada";
        List<Cita> citasMock = List.of(new Cita());

        when(citaRepository.findByUsuarioCorreoAndEstado(correo, estado)).thenReturn(citasMock);

        List<Cita> resultado = citaService.filtrarCitasPorEstado(correo, estado);
        assertEquals(1, resultado.size());
    }
}
