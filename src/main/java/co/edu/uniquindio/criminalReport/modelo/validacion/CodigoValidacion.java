package co.edu.uniquindio.criminalReport.modelo.validacion;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CodigoValidacion {

    private String codigo;
    private LocalDateTime fechaCreacion;

}