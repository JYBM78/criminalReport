package co.edu.uniquindio.criminalReport.dto;

import co.edu.uniquindio.criminalReport.modelo.enums.Ciudad;
import co.edu.uniquindio.criminalReport.modelo.enums.EstadoUsuario;

public record UsuarioDTO(
        String id,
        String nombre,
        Ciudad ciudad,
        String direccion,
        String telefono,
        String email,
        EstadoUsuario estado
) {
}
