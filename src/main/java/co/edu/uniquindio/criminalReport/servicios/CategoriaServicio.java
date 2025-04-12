package co.edu.uniquindio.criminalReport.servicios;

import co.edu.uniquindio.criminalReport.dto.CategoriaDTO;
import co.edu.uniquindio.criminalReport.dto.CrearCategoriaDTO;
import co.edu.uniquindio.criminalReport.dto.InfocategoriaDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CategoriaServicio {
    void crearCategoria(CrearCategoriaDTO categoria) throws Exception;
    void editarCategoria(String id, @Valid CrearCategoriaDTO categoria) throws Exception;
    void eliminarCategoria(String id) throws Exception;
    InfocategoriaDTO obtenerCategoria(String id) throws Exception;
    List<CategoriaDTO> listar();
}
