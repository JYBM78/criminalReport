package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record LoginDTO(
        @NotBlank(message = "El mail no puede estar vacía")
        @Email(message = "Dede usar un formato válido para email")String email,
        @NotBlank(message = "La contraseña no puede estar vacía") @Length(min=6, max=10) String password
) {
}
