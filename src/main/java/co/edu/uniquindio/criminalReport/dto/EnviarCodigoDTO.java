package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EnviarCodigoDTO(
        @NotBlank @Email String email
) {}
