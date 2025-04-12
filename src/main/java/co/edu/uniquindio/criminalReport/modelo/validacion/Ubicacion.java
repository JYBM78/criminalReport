package co.edu.uniquindio.criminalReport.modelo.validacion;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Ubicacion {
    private double latitud;
    private double longitud;
}
