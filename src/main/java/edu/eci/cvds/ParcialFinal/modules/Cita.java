package edu.eci.cvds.ParcialFinal.modules;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "citas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {
    @Id
    private String id;
    private Usuario usuario;
    private Especialidad especialidad;
    private LocalDate fecha;
    private String estado;
}
