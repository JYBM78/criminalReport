package co.edu.uniquindio.criminalReport.mapper;

import co.edu.uniquindio.criminalReport.dto.CrearReporteDTO;
import co.edu.uniquindio.criminalReport.dto.EditarReporteDTO;
import co.edu.uniquindio.criminalReport.dto.ReporteDTO;
import co.edu.uniquindio.criminalReport.dto.UbicacionDTO;
import co.edu.uniquindio.criminalReport.modelo.documentos.Reporte;
import org.mapstruct.*;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Mapper(componentModel = "spring")
public interface ReporteMapper {

    Reporte toDocument(CrearReporteDTO crearReporteDTO);

    void toDocument(EditarReporteDTO editarReporteDTO, @MappingTarget Reporte reporte);

    default ReporteDTO toDTO(Reporte reporte) {
        if (reporte == null) return null;

        return new ReporteDTO(
                reporte.getId(),
                reporte.getNombre(),
                reporte.getDescripcion(),
                reporte.getCategoria(),
                reporte.getFechaCreacion(),
                reporte.getEstado(),
                geoJsonPointToUbicacionDTO(reporte.getUbicacion()),
                reporte.getConteoImportante()

        );
    }

    default UbicacionDTO geoJsonPointToUbicacionDTO(GeoJsonPoint point) {
        if (point == null) return null;
        return new UbicacionDTO(point.getY(), point.getX()); // Y = latitud, X = longitud
    }
}
