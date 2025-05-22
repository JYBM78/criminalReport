package co.edu.uniquindio.criminalReport.dto;

import co.edu.uniquindio.criminalReport.modelo.enums.EstadoReporte;

import java.time.LocalDateTime;
import java.util.Map;

public record ReporteDTO(
        String id,
        String nombre,
        String descripcion,
        String categoria,
        LocalDateTime fechaCreacion,
        EstadoReporte estado,
        UbicacionDTO ubicacionDTO,
        int conteoImportantes


) {}

