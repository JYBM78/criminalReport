package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record CrearReporteDTO(
        @NotBlank @Length(max = 150, message = "El título no puede estar vacío") String titulo,
        @NotBlank @Length(max = 400, message = "La descripción no puede estar vacío") String descripcion,

        @NotEmpty List<String> rutaImagenes,
        @NotBlank(message = "La categoría no puede estar vacía") String idCategoria,
        @NotNull(message = "La ubicación no puede estar vacía") UbicacionDTO ubicacion,
        List<String> fotos,
        @NotBlank String idCliente,
        boolean importante
) {
}
/*
9.	Cree los DTO con los atributos correspondientes para los métodos del CRUD.
Un DTO es una clase que encapsula la información necesaria para cada requisito específico
de la aplicación, separando la lógica de negocio de la estructura de los datos que
se intercambian entre el cliente y el servidor.

Dado que los DTO son objetos que no tienen lógica y solo sirven para encapsular atributos,
 podemos hacer uso de los record de Java.

 El DTO debe tener las validaciones pertinentes para garantizar una buena integridad de los datos.
  Todos los DTO que represente un objeto que será guardado en la base de datos y
  debe tener las validaciones.
 */

