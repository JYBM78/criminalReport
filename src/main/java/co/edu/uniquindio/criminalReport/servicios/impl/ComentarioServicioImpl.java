package co.edu.uniquindio.criminalReport.servicios.impl;

import co.edu.uniquindio.criminalReport.dto.ComentarioDTO;
import co.edu.uniquindio.criminalReport.servicios.ComentarioServicio;

import java.util.List;

public class ComentarioServicioImpl implements ComentarioServicio {
    @Override
    public List<ComentarioDTO> obtenerComentarios(String idReporte) throws Exception {
        return List.of();
    }

    @Override
    public void crearComentario(String idReporte, ComentarioDTO comentarioDTO) throws Exception {

    }
}
