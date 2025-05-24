package edu.eci.cvds.ParcialFinal.repositories;

import edu.eci.cvds.ParcialFinal.modules.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}