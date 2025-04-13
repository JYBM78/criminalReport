package co.edu.uniquindio.criminalReport.mapper;

import co.edu.uniquindio.criminalReport.dto.CategoriaDTO;
import co.edu.uniquindio.criminalReport.dto.CrearCategoriaDTO;
import co.edu.uniquindio.criminalReport.modelo.documents.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toDocument(CrearCategoriaDTO dto);
    // Para listar: de documento a DTO
    CategoriaDTO toDTO(Categoria categoria);
}
