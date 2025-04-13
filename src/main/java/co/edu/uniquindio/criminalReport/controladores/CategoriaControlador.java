package co.edu.uniquindio.criminalReport.controladores;

import co.edu.uniquindio.criminalReport.dto.CategoriaDTO;
import co.edu.uniquindio.criminalReport.dto.CrearCategoriaDTO;
import co.edu.uniquindio.criminalReport.dto.MensajeDTO;
import co.edu.uniquindio.criminalReport.servicios.CategoriaServicio;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categorias")
public class CategoriaControlador {

    private final CategoriaServicio categoriaServicio;

    // Crear una nueva categoría (solo administradores)
    @PostMapping("/crearCategoríaReporte")
    public ResponseEntity<MensajeDTO<String>> crear(@Valid @RequestBody CrearCategoriaDTO categoria) throws Exception {
        categoriaServicio.crearCategoria(categoria);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Categoría creada exitosamente"));
    }

    // Editar una categoría existente

    @PutMapping("/{id}editarCategoría")
    public ResponseEntity<MensajeDTO<String>> editar(@PathVariable String id, @Valid @RequestBody CrearCategoriaDTO categoria) throws Exception {
        categoriaServicio.editarCategoria(id, categoria);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Categoría actualizada correctamente"));
    }


    // Eliminar una categoría
    @DeleteMapping("/{id}eliminarCategoría")
    public ResponseEntity<MensajeDTO<String>> eliminar(@PathVariable String id) throws Exception {
        categoriaServicio.eliminarCategoria(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Categoría eliminada correctamente"));
    }

    // Listar todas las categorías
    @GetMapping("/listarCategorias")
    /*
    public ResponseEntity<List<CategoriaDTO>> listar() {
        List<CategoriaDTO> categorias = categoriaServicio.listar();
        return ResponseEntity.ok(categorias);
    }*/
    public ResponseEntity<List<CategoriaDTO>> listar(
            @Parameter(description = "Filtro opcional para buscar categorías")
            @RequestParam(required = false) String filtro) {
        List<CategoriaDTO> categorias = categoriaServicio.listar(filtro);
        return ResponseEntity.ok(categorias);

    }
}