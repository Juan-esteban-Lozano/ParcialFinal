package edu.eci.cvds.ParcialFinal.controllers;

import edu.eci.cvds.ParcialFinal.modules.Especialidad;
import edu.eci.cvds.ParcialFinal.repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@CrossOrigin
public class EspecialidadController {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @GetMapping
    public List<Especialidad> obtenerEspecialidades() {
        return especialidadRepository.findAll();
    }
}