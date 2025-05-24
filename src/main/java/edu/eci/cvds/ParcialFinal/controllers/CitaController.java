package edu.eci.cvds.ParcialFinal.controllers;

import edu.eci.cvds.ParcialFinal.modules.Cita;
import edu.eci.cvds.ParcialFinal.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping("/programar")
    public ResponseEntity<Cita> programarCita(@RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.programarCita(cita));
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Cita>> obtenerCitasPorCorreo(@RequestParam String correo) {
        return ResponseEntity.ok(citaService.obtenerCitasPorCorreo(correo));
    }

    @GetMapping("/usuario/estado")
    public ResponseEntity<List<Cita>> filtrarPorEstado(@RequestParam String correo, @RequestParam String estado) {
        return ResponseEntity.ok(citaService.filtrarCitasPorEstado(correo, estado));
    }

    @PostMapping("/cancelar/{id}")
    public ResponseEntity<Cita> cancelarCita(@PathVariable String id) {
        return ResponseEntity.ok(citaService.cancelarCita(id));
    }
}