package co.edu.uniquindio.criminalReport.repositorios;

import co.edu.uniquindio.criminalReport.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByNombreAndCiudad(String nombre, String ciudad);
}
