package edu.eci.cvds.ParcialFinal.repositories;

import edu.eci.cvds.ParcialFinal.modules.Especialidad;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EspecialidadRepository extends MongoRepository<Especialidad, String> {
}