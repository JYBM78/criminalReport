package co.edu.uniquindio.criminalReport.servicios;

import co.edu.uniquindio.criminalReport.dto.ActualizarCategoriaDTO;
import co.edu.uniquindio.criminalReport.dto.CategoriaDTO;
import co.edu.uniquindio.criminalReport.dto.CrearCategoriaDTO;

import java.util.List;

public interface CategoriaServicio {

    CategoriaDTO crearCategoria(CrearCategoriaDTO dto) throws Exception;

    void actualizarCategoria(String id, ActualizarCategoriaDTO categoria) throws Exception;

    void eliminarCategoria(String id) throws Exception;

    CategoriaDTO obtenerCategoria(String id) throws Exception;

    List<CategoriaDTO> listarCategorias() throws Exception;
}
