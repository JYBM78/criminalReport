package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.NotBlank;

public record CrearCategoriaDTO(
        @NotBlank String nombre,
        @NotBlank String descripcion
) {}
