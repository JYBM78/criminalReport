package co.edu.uniquindio.criminalReport.dto;

import org.bson.types.ObjectId;

public record CategoriaDTO(
    ObjectId id,
    String nombre,
    String icono
){

}