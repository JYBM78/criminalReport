package co.edu.uniquindio.criminalReport.dto;

import java.time.Instant;

public record GenerarTokenDTO(String token, Instant expiracion) {
}
