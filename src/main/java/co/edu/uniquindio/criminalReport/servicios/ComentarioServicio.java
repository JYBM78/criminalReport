package co.edu.uniquindio.criminalReport.servicios;

import co.edu.uniquindio.criminalReport.dto.CrearComentarioDTO;
import co.edu.uniquindio.criminalReport.modelo.documentos.Comentario;

import java.util.List;

public interface ComentarioServicio {
    Comentario crearComentario(String idReporte, CrearComentarioDTO dto) throws Exception;

    List<Comentario> obtenerComentariosPorIdReporte(String idReporte) throws Exception;

}



