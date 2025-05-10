package co.edu.uniquindio.criminalReport.mapper;

import co.edu.uniquindio.criminalReport.dto.ComentarioDTO;
import co.edu.uniquindio.criminalReport.dto.CrearComentarioDTO;
import co.edu.uniquindio.criminalReport.modelo.documents.Comentario;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {

    // Entrada: CrearComentarioDTO -> Comentario
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    @Mapping(target = "idReporte", ignore = true)
    @Mapping(target = "idUsuario", source = "idCliente")
    Comentario toDocument(CrearComentarioDTO crearComentarioDTO);

    // Salida: Comentario -> ComentarioDTO
    @Mapping(source = "idUsuario", target = "idCliente")
    ComentarioDTO toDTO(Comentario comentario);

    // Conversión personalizada
    default ObjectId map(String value) {
        return value != null ? new ObjectId(value) : null;
    }

    default String map(ObjectId value) {
        return value != null ? value.toHexString() : null;
    }
}
