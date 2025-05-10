package co.edu.uniquindio.criminalReport.repositorios;

import co.edu.uniquindio.criminalReport.modelo.documents.Comentario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ComentarioRepositorio extends MongoRepository<Comentario, ObjectId> {
    List<Comentario> findByIdReporte(ObjectId idReporte);

    List<Comentario> findByIdUsuario(ObjectId idUsuario);

    void deleteByIdReporte(ObjectId idReporte);

    long countByIdReporte(ObjectId idReporte);

}
