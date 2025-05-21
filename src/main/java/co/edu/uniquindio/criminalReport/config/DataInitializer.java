package co.edu.uniquindio.criminalReport.config;

import co.edu.uniquindio.criminalReport.modelo.documentos.Usuario;
import co.edu.uniquindio.criminalReport.modelo.enums.EstadoUsuario;
import co.edu.uniquindio.criminalReport.modelo.enums.Rol;
import co.edu.uniquindio.criminalReport.repositorios.UsuarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepo usuarioRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Verifica si el admin ya existe
        if (usuarioRepo.findByEmail("admin@criminal.report.com").isEmpty()) {
            Usuario admin = Usuario.builder()
                    .nombre("Administrador General")
                    .email("admin@criminal.report.com")
                    .password(passwordEncoder.encode("1234567"))
                    .rol(Rol.ADMINISTRADOR)
                    .estado(EstadoUsuario.ACTIVO)
                    .build();

            usuarioRepo.save(admin);
            System.out.println("Administrador creado por defecto");
        } else {
            System.out.println("El Administrador ya está cargado en la BD");
        }
    }
}
