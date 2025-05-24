package edu.eci.cvds.ParcialFinal.repositories;

import edu.eci.cvds.ParcialFinal.modules.Cita;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CitaRepository extends MongoRepository<Cita, String> {
    List<Cita> findByUsuarioCorreo(String correo);
    List<Cita> findByUsuarioCorreoAndEstado(String correo, String estado);
}
