package co.edu.uniquindio.criminalReport.repositorios;

import co.edu.uniquindio.criminalReport.modelo.documents.Categoria;
import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepositorio extends MongoRepository<Categoria, ObjectId> {
    
    Optional<Categoria> findByNombre(String nombre);
    
    boolean existsByNombre(String nombre);

    boolean existsByNombreIgnoreCase(@NotBlank(message = "El nombre no puede estar vacío") String nombre);

    List<Categoria> findByNombreContainingIgnoreCase(String nombre);
}