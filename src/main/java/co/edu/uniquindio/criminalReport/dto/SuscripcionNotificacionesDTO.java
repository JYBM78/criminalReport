package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.NotNull;

public record SuscripcionNotificacionesDTO(
        @NotNull Boolean notificacion_app,
        @NotNull Boolean notificacion_email

) {}
