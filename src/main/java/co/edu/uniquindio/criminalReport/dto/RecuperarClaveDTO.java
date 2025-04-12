package co.edu.uniquindio.criminalReport.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RecuperarClaveDTO(

        @NotBlank @Email @Length(max = 30) String email
) {
}
