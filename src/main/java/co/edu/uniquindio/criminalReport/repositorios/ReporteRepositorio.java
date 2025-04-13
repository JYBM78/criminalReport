package co.edu.uniquindio.criminalReport.repositorios;

import co.edu.uniquindio.criminalReport.modelo.documents.Reporte;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepositorio extends MongoRepository<Reporte, ObjectId> {

    // Buscar reportes por el ID del usuario que los creó
    List<Reporte> findByIdCliente(ObjectId idCliente);

    // Buscar reportes por estado
    List<Reporte> findByEstadoActual(String estadoActual);

    // Buscar reportes que contengan una palabra clave en el título
    List<Reporte> findByTituloContainingIgnoreCase(String titulo);

    // Buscar reportes en una categoría específica
    List<Reporte> findByIdCategoria(ObjectId idCategoria);

    List<Reporte> findByEmail(String email); // Este metodo buscará reportes por el email del usuario

}