package co.edu.uniquindio.criminalReport.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ReporteDTO(
        String id,
        String titulo,
        String descripcion,
        String estado,
        LocalDateTime fecha,
        boolean importante,
        String idCliente,
        String nombreCliente,
        UbicacionDTO ubicacion,
        String idCategoria,
        String nombreCategoria,
        List<String> fotos
){}