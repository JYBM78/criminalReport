package co.edu.uniquindio.criminalReport.dto;

public record UsuarioDTO(
    String id,
    String nombre,
    String ciudad,
    String telefono,
    String email,
    String rol,
    String estado
) {
}
