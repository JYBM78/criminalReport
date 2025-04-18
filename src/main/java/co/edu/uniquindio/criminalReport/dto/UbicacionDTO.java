package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.NotNull;

public record UbicacionDTO(
        @NotNull(message = "La latitud es obligatoria")
        Double latitud,

        @NotNull(message = "La longitud es obligatoria")
        Double longitud
) {
}
