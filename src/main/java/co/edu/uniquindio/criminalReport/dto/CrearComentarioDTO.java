package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.NotBlank;


public record CrearComentarioDTO(
        @NotBlank(message = "El mensaje No puede estar vacío")
        String mensaje,

        @NotBlank(message = "El ID del cliente No puede estar vacío")
        String idCliente,

        @NotBlank(message = "El ID del reporte No puede estar vacío")
        String idReporte
){}