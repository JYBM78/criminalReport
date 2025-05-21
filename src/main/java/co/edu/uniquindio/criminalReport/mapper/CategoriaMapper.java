package co.edu.uniquindio.criminalReport.mapper;

import co.edu.uniquindio.criminalReport.dto.CategoriaDTO;
import co.edu.uniquindio.criminalReport.dto.CrearCategoriaDTO;
import co.edu.uniquindio.criminalReport.modelo.documentos.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toDocument(CrearCategoriaDTO crearCategoriaDTO);

    CategoriaDTO toDTO(Categoria categoria);
}
