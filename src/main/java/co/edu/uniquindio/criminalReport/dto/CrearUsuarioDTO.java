package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CrearUsuarioDTO(
        @NotBlank @Length(min =1, max = 1000) String id, //asignar id manual, para automático borrar y modificarUsuarioServicioImpl.java método crear
        @NotBlank @Length(max = 50) String nombre,
        @Length(max = 10) String telefono,
        @NotBlank @Length(max = 50) String ciudad,
        @NotBlank @Length(max = 100) String direccion,
        @NotBlank @Length(max = 30) @Email String email,
        @NotBlank @Length(min = 6, max = 20) String password
) {
}

