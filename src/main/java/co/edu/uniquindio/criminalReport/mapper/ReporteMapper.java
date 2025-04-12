/*
package co.edu.uniquindio.criminalReport.mapper;

import co.edu.uniquindio.criminalReport.dto.CrearReporteDTO;
import co.edu.uniquindio.criminalReport.dto.EditarReporteDTO;
import co.edu.uniquindio.criminalReport.dto.ReporteDTO;
import co.edu.uniquindio.criminalReport.dto.UbicacionDTO;
import co.edu.uniquindio.criminalReport.modelo.documents.Reporte;
import co.edu.uniquindio.criminalReport.modelo.validacion.Ubicacion;
import org.bson.types.ObjectId;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReporteMapper {

    @Mapping(target = "ubicacion", source = "ubicacion")
    Reporte toDocument(CrearReporteDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idCliente", ignore = true)
    @Mapping(target = "idCategoria", ignore = true)
    @Mapping(target = "estadoActual", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    @Mapping(target = "contadorImportante", ignore = true)
    @Mapping(target = "historial", ignore = true)
    void editarReporteDTO(EditarReporteDTO dto, @MappingTarget Reporte reporte);
    // Conversión personalizada de String a ObjectId
    default ObjectId map(String value) {
        return new ObjectId(value);
    }
    // Conversión personalizada de ObjectId a String (para toDTO)
    default String map(ObjectId value) { return value != null ? value.toHexString() : null;
    }

    // Conversión personalizada para ubicación
    default Ubicacion mapUbicacionDTO(UbicacionDTO dto) {
        return new Ubicacion(dto.latitud(), dto.longitud());
    }
    // Conversión de documento a DTO
    ReporteDTO toDTO(Reporte reporte);
}
*/
package co.edu.uniquindio.criminalReport.mapper;

import co.edu.uniquindio.criminalReport.dto.CrearReporteDTO;
import co.edu.uniquindio.criminalReport.dto.EditarReporteDTO;
import co.edu.uniquindio.criminalReport.dto.ReporteDTO;
import co.edu.uniquindio.criminalReport.dto.UbicacionDTO;
import co.edu.uniquindio.criminalReport.modelo.documents.Reporte;
import co.edu.uniquindio.criminalReport.modelo.validacion.Ubicacion;
import org.bson.types.ObjectId;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReporteMapper {

    // Crear Reporte desde CrearReporteDTO
    @Mapping(target = "idCliente", source = "idCliente")
    @Mapping(target = "idCategoria", source = "idCategoria")
    @Mapping(target = "ubicacion", source = "ubicacion")
    @Mapping(target = "fecha", ignore = true)
    @Mapping(target = "estadoActual", ignore = true)
    @Mapping(target = "contadorImportante", ignore = true)
    @Mapping(target = "historial", ignore = true)
    @Mapping(target = "id", ignore = true)
    Reporte toDocument(CrearReporteDTO dto);

    // Editar Reporte desde EditarReporteDTO
    @Mapping(target = "ubicacion", source = "ubicacion")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idCliente", ignore = true)
    @Mapping(target = "idCategoria", ignore = true)
    @Mapping(target = "estadoActual", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    @Mapping(target = "contadorImportante", ignore = true)
    @Mapping(target = "historial", ignore = true)
    void editarReporteDTO(EditarReporteDTO dto, @MappingTarget Reporte reporte);

    // Conversión de Reporte a ReporteDTO
    @Mapping(target = "idCategoria", expression = "java(map(reporte.getIdCategoria()))")
    ReporteDTO toDTO(Reporte reporte);

    // Conversión personalizada de String a ObjectId
    default ObjectId map(String value) {
        return value != null ? new ObjectId(value) : null;
    }

    // Conversión personalizada de ObjectId a String
    default String map(ObjectId value) {
        return value != null ? value.toHexString() : null;
    }

    // Conversión personalizada de UbicacionDTO a Ubicacion
    default Ubicacion map(UbicacionDTO dto) {
        return dto != null ? new Ubicacion(dto.latitud(), dto.longitud()) : null;
    }

    // Conversión de Ubicacion a UbicacionDTO
    default UbicacionDTO map(Ubicacion ubicacion) {
        return ubicacion != null ? new UbicacionDTO(ubicacion.getLatitud(), ubicacion.getLongitud()) : null;
    }
}

