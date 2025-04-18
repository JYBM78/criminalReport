package co.edu.uniquindio.criminalReport.servicios;

import co.edu.uniquindio.criminalReport.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioServicio {
    List<ComentarioDTO> obtenerComentarios(String idReporte) throws Exception;
    void crearComentario(String idReporte, ComentarioDTO comentarioDTO) throws Exception;
}
