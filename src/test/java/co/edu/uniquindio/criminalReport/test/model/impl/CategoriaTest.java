package co.edu.uniquindio.criminalReport.test.model.impl;

import co.edu.uniquindio.criminalReport.modelo.documentos.Categoria;
import co.edu.uniquindio.criminalReport.repositorios.CategoriaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoriaTest {

    @Autowired
    private CategoriaRepo categoriaRepo;

    @Test
    public void registrarCategoriaTest() {
        Categoria categoria = new Categoria();
        categoria.setNombre("incendio en Cali");
        categoria.setDescripcion("Reporte de incendio en Cali");

        Categoria categoriaGuardada = categoriaRepo.save(categoria);
        assertNotNull(categoriaGuardada, "La categoría no fue guardada correctamente");
    }

    @Test
    public void actualizarCategoriaTest() {
        Categoria categoria = new Categoria();
        categoria.setNombre("incendio en Cali");
        categoria.setDescripcion("Reporte de incendio en Cali");

        Categoria guardada = categoriaRepo.save(categoria);
        guardada.setDescripcion("Reporte de incendio");

        assertEquals("Reporte de incendio", guardada.getDescripcion());
    }

    @Test
    public void eliminarCategoriaTest() {
        List<Categoria> categorias = categoriaRepo.findAll();

        Categoria primercategoria = categorias.getFirst();
        categoriaRepo.delete(primercategoria);

    }

    @Test
    public void buscarCategoriaTest() {
        Categoria categoria = new Categoria();
        categoria.setNombre("incendio en Cali");
        categoria.setDescripcion("Reporte de accidente en Cali");

        Categoria guardada = categoriaRepo.save(categoria);

        Optional<Categoria> encontrada = categoriaRepo.findById(guardada.getId());
        assertTrue(encontrada.isPresent(), "No se encontró la categoría");
        System.err.println("Categoría encontrada: " + encontrada.get().getNombre());
    }

    @Test
    public void mostrarCategoriasTest() {
        List<Categoria> categorias = categoriaRepo.findAll();
        for (Categoria categoria : categorias) {
            System.err.println("ID: " + categoria.getId() +
                    ", Nombre: " + categoria.getNombre() +
                    ", Descripción: " + categoria.getDescripcion());
        }
        assertFalse(categorias.isEmpty(), "No se encontraron categorías en la base de datos");
    }
}
