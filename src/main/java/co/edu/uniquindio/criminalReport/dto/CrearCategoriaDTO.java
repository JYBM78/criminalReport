package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.NotBlank;

public record CrearCategoriaDTO(

    @NotBlank(message = "El nombre no puede estar vacío")
    String nombre
){

}
