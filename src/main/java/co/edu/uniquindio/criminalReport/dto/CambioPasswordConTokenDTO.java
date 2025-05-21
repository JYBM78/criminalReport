package co.edu.uniquindio.criminalReport.dto;

public record CambioPasswordConTokenDTO(
        String token,
        String email,
        String nuevaPassword) {
}
