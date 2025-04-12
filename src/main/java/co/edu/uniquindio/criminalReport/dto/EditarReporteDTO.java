package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record EditarReporteDTO (

        @NotBlank(message = "El título no puede estar vacío")
        String titulo,

        @NotBlank(message = "La descripción no puede estar vacía")
        String descripcion,

        UbicacionDTO ubicacion,

        String idCategoria,

        boolean importante,

        List<String> fotos
){}
