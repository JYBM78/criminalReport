package co.edu.uniquindio.criminalReport.modelo;

//import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios") // Para MongoDB, usar @Entity si es SQL
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    private String id;


    private String nombre;


    private String email;


    private String password;


    private String ciudad;


    private String direccion;

    private boolean activo = true; // Para eliminaciones lógicas
}
