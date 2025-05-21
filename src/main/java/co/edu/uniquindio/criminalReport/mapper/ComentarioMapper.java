package co.edu.uniquindio.criminalReport.mapper;

import co.edu.uniquindio.criminalReport.dto.CrearComentarioDTO;
import co.edu.uniquindio.criminalReport.modelo.documentos.Comentario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {

    Comentario crearDtoToComentario(CrearComentarioDTO dto);

    // Usar un método default para asignar los valores manualmente
    default void completarDatos(@MappingTarget Comentario comentario, String idUsuario, String idReporte) {
        comentario.setComentarioTexto(comentario.getComentarioTexto());
        comentario.setUsuarioId(idUsuario);
        comentario.setReporteId(idReporte);
    }
}




