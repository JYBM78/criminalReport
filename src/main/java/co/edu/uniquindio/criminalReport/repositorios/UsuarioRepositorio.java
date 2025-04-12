package co.edu.uniquindio.criminalReport.repositorios;

import co.edu.uniquindio.criminalReport.modelo.documents.Usuario;
import co.edu.uniquindio.criminalReport.modelo.enums.EstadoUsuario;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByNombreContaining(String nombre);

    List<Usuario> findByCiudad(String ciudad);

    List<Usuario> findByNombreContainingAndCiudad(String nombre, String ciudad);

    List<Usuario> findByNombreContainingIgnoreCaseAndEstado(String nombre, EstadoUsuario estado, Pageable pageable);

    List<Usuario> findByCiudadContainingIgnoreCaseAndEstado(String ciudad, EstadoUsuario estado, Pageable pageable);

    List<Usuario> findByNombreContainingIgnoreCaseAndCiudadContainingIgnoreCaseAndEstado(
            String nombre, String ciudad, EstadoUsuario estado, Pageable pageable);

    boolean existsByEmail(String email);
}
