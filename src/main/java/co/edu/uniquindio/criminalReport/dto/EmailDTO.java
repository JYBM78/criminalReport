package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.NotBlank;

public record EmailDTO(
        @NotBlank String email,
        @NotBlank String asunto,
        @NotBlank String mensaje
) {
}
