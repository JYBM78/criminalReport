package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record EditarUsuarioDTO(
    @NotBlank(message = "El id es obligatorio") String id,
    @NotBlank @Length(max = 50, message = "El nombre es obligatorio") String nombre,
    @NotNull(message = "La cuidad no puede estar vacía") String ciudad,
    @NotBlank @Length(max = 100, message = "La dirección es obligatoria") String direccion,
    @Length(max = 10) String telefono
) {
}
