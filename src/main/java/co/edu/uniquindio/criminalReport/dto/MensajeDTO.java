package co.edu.uniquindio.criminalReport.dto;

public record MensajeDTO<T>(boolean error, String mensaje, T data) {
}

