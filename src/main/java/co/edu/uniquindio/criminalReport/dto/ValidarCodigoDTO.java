package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ValidarCodigoDTO(
        @NotBlank(message = "El email no puede estar vacío")
        @Email(message = "Use un formato de email válido")
        String email,

        @NotBlank(message = "El código no puede estar vacío")
        String codigo
){}