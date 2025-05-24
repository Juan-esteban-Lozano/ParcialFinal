package edu.eci.cvds.ParcialFinal.modules;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "especialidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especialidad {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String imagenUrl;
    private String ubicacion;
    private Doctor doctor;
}
