package edu.eci.cvds.ParcialFinal.services;

import edu.eci.cvds.ParcialFinal.modules.*;
import edu.eci.cvds.ParcialFinal.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public Cita programarCita(Cita cita) {
        if (cita.getFecha() == null || cita.getFecha().isBefore(LocalDate.now())) {
            cita.setEstado("Rechazada");
        } else {
            cita.setEstado("Confirmada");
        }
        return citaRepository.save(cita);
    }

    public List<Cita> obtenerCitasPorCorreo(String correo) {
        return citaRepository.findByUsuarioCorreo(correo);
    }

    public List<Cita> filtrarCitasPorEstado(String correo, String estado) {
        return citaRepository.findByUsuarioCorreoAndEstado(correo, estado);
    }

    public Cita cancelarCita(String idCita) {
        Cita cita = citaRepository.findById(idCita)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setEstado("Cancelada");
        return citaRepository.save(cita);
    }
}
