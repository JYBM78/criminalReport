package co.edu.uniquindio.criminalReport.modelo.validacion;

import co.edu.uniquindio.criminalReport.modelo.enums.EstadoReporte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class HistorialReporte {

    private EstadoReporte estado;
    private String observacion;
    private LocalDateTime fecha;
    private ObjectId idCliente;
}
