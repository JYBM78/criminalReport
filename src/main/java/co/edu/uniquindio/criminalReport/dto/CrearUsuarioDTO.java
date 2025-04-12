package co.edu.uniquindio.criminalReport.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Schema(description = "DTO para crear un usuario")
public record CrearUsuarioDTO(
        @NotBlank @Length(max = 30, message = "El correo es obligatorio") @Email String email,
        @NotBlank @Length(min =1, max = 1000) String id, //asignar id manual, para automático borrar y modificarUsuarioServicioImpl.java métodos crear
        @NotBlank @Length(max = 50, message = "El nombre no puede estar vacío") String nombre,
        @Length(max = 10) String telefono,
        @NotBlank @Length(max = 50, message = "La ciudad no puede estar vacía") String ciudad,
        @NotBlank @Length(max = 100, message = "La dirección no puede estar vacía") String direccion,
        @NotBlank @Length(min = 6, max = 10, message = "La contraseña es obligatoria") String password
) {
}

