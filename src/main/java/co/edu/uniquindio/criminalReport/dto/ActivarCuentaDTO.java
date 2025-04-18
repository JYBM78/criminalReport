package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ActivarCuentaDTO(
        @NotBlank String codigoValidacion,
        @NotBlank @Email String email
) {}
