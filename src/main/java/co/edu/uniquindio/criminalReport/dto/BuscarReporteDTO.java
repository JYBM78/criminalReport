package co.edu.uniquindio.criminalReport.dto;

import java.time.LocalDate;

public record BuscarReporteDTO(
        String txtConsulta,
        String categoria,
        String estado,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Double latitud,
        Double longitud
) {}
