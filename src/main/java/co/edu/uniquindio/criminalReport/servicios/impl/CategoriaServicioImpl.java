package co.edu.uniquindio.criminalReport.servicios.impl;

import co.edu.uniquindio.criminalReport.dto.CategoriaDTO;
import co.edu.uniquindio.criminalReport.dto.CrearCategoriaDTO;
import co.edu.uniquindio.criminalReport.dto.InfocategoriaDTO;
import co.edu.uniquindio.criminalReport.mapper.CategoriaMapper;
import co.edu.uniquindio.criminalReport.modelo.documents.Categoria;
import co.edu.uniquindio.criminalReport.repositorios.CategoriaRepositorio;
import co.edu.uniquindio.criminalReport.servicios.CategoriaServicio;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServicioImpl implements CategoriaServicio {

    private  final CategoriaRepositorio categoriaRepositorio;
    private final CategoriaMapper categoriaMapper;


    @Override
    public void crearCategoria(CrearCategoriaDTO dto) throws Exception {
        // Validar si ya existe una categoría con el mismo nombre (opcional pero recomendable)
        if (categoriaRepositorio.existsByNombreIgnoreCase(dto.nombre())) {
            throw new Exception("La categoría ya está en uso: " + dto.nombre());
        }
        Categoria categoria = categoriaMapper.toDocument(dto);
        categoriaRepositorio.save(categoria);
    }

    @Override
    public void editarCategoria(String id, CrearCategoriaDTO categoriaDTO) throws Exception {
        Categoria categoriaExistente = categoriaRepositorio.findById(new ObjectId(id))
                .orElseThrow(() -> new Exception("Categoría ID " + id + " no existe"));
        boolean existeOtra = categoriaRepositorio.existsByNombreIgnoreCase(categoriaDTO.nombre())
                && !categoriaExistente.getNombre().equalsIgnoreCase(categoriaDTO.nombre());
        if (existeOtra) {
            throw new Exception("La categoría: " + categoriaDTO.nombre() + "Ya está en uso");
        }
        categoriaExistente.setNombre(categoriaDTO.nombre());
        categoriaRepositorio.save(categoriaExistente);
    }

    @Override
    public void eliminarCategoria(String id) throws Exception {
        ObjectId objectId = new ObjectId(id);
        if (!categoriaRepositorio.existsById(objectId)) {
            throw new Exception("Categoría con el ID: " + objectId + "no encontrada");
        }
        categoriaRepositorio.deleteById(objectId);
    }
/*
    @Override
    public List<CategoriaDTO> listar() {
        return categoriaRepositorio.findAll()
                .stream()
                .map(categoriaMapper::toDTO)
                .toList();
    }*/
@Override
public List<CategoriaDTO> listar(String filtro) {
    List<Categoria> categorias;

    if (filtro != null && !filtro.isBlank()) {
        categorias = categoriaRepositorio.findByNombreContainingIgnoreCase(filtro);
    } else {
        categorias = categoriaRepositorio.findAll();
    }

    return categorias.stream()
            .map(categoriaMapper::toDTO)
            .toList();
}

    @Override
    public InfocategoriaDTO obtenerCategoria(String id) throws Exception {
        return null;
    }



}
