package co.edu.uniquindio.criminalReport.modelo.documents;

import co.edu.uniquindio.criminalReport.modelo.enums.TipoNotificacion;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("notificaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notificacion {

    @Id
    @EqualsAndHashCode.Include
    private ObjectId id;

    private String mensaje;
    private LocalDateTime fecha;
    private TipoNotificacion tipoNotificacion;
    private boolean leida;
    private ObjectId idReporte;
    private ObjectId idUsuario;
}
