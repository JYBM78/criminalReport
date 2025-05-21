package co.edu.uniquindio.criminalReport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificacionDTO {
    private String mensaje;
    private String cuerpo;
    private String topic;

}



// private double latitud;
// private double longitud;