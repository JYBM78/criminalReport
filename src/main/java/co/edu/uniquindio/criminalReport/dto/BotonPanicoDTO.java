package co.edu.uniquindio.criminalReport.dto;

public record BotonPanicoDTO(
        String idCliente,
        String descripcion, // opcional
        double latitud,
        double longitud
) {}

