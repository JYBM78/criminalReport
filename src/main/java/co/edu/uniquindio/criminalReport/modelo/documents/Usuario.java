package co.edu.uniquindio.criminalReport.modelo.documents;

//import jakarta.persistence.*;
import co.edu.uniquindio.criminalReport.modelo.enums.Ciudad;
import co.edu.uniquindio.criminalReport.modelo.enums.EstadoUsuario;
import co.edu.uniquindio.criminalReport.modelo.enums.Rol;
import co.edu.uniquindio.criminalReport.modelo.validacion.CodigoValidacion;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "usuarios") // Para MongoDB, usar @Entity si es SQL
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private String email;

    private String password;

    private String nombre;

    private String telefono;

    private String direccion;

    private Ciudad ciudad;
    private Rol rol;
    private EstadoUsuario estado;

    private CodigoValidacion codigoValidacion;

    private LocalDateTime fechaRegistro;

    private int cantidadReportes = 0;

    // Getters, setters y constructores

}
