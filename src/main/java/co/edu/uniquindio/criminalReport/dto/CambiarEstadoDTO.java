package co.edu.uniquindio.criminalReport.dto;

import co.edu.uniquindio.criminalReport.modelo.enums.EstadoReporte;
import jakarta.validation.constraints.NotNull;

public record CambiarEstadoDTO(
        @NotNull EstadoReporte nuevoEstado

) {
}
