package co.edu.uniquindio.criminalReport.controladores;

import co.edu.uniquindio.criminalReport.dto.*;
import co.edu.uniquindio.criminalReport.servicios.UsuarioServicio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @GetMapping("/{email}/reportes")
    public ResponseEntity<MensajeDTO<List<InfoReporteDTO>>> obtenerReportesUsuario(@PathVariable String id) throws Exception {
        List<InfoReporteDTO> lista = usuarioServicio.obtenerReportesUsuario(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, lista));
    }

    @GetMapping("/bucarUsuario{id}")
    public ResponseEntity<MensajeDTO<UsuarioDTO>> obtener(@PathVariable String id) throws Exception {
        UsuarioDTO dto = usuarioServicio.obtener(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, dto));
    }

    // Listar usuarios con filtros y paginación
    @GetMapping("/buscarUsuarioNombre")
    public ResponseEntity<MensajeDTO<List<UsuarioDTO>>> listarTodos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String ciudad,
            @RequestParam(defaultValue = "0") int pagina
    ) {
        List<UsuarioDTO> lista = usuarioServicio.listarTodos(nombre, ciudad, pagina);
        return ResponseEntity.ok(new MensajeDTO<>(false, lista));
    }

    // Registro de usuario
    @PostMapping("/registrarNuevoUsuario")
    public ResponseEntity<MensajeDTO<String>> crear(@Valid @RequestBody CrearUsuarioDTO cuenta) throws Exception {
        usuarioServicio.crear(cuenta);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Registro exitoso. Verifica tu correo para activar tu cuenta."));
    }

    @PostMapping("/enviarCodigoVerificacion")
    public ResponseEntity<MensajeDTO<String>> enviarCodigoVerificacion(@RequestBody EnviarCodigoDTO enviarCodigoDTO) throws Exception {
        usuarioServicio.enviarCodigoVerificacion(enviarCodigoDTO);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Codigo enviado correctamente."));
    }

    // Edición de perfil
    @PutMapping("/editarPerfil{id}")
    public ResponseEntity<MensajeDTO<String>> editar(@PathVariable String id, @Valid @RequestBody EditarUsuarioDTO editarUsuarioDTO) throws Exception {
        usuarioServicio.editar(id,editarUsuarioDTO);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Perfil actualizado correctamente."));
    }

    @PutMapping("/{email}/CambiarPassword")
    public ResponseEntity<MensajeDTO<String>> cambiarPassword(@RequestBody CambiarPasswordDTO cambiarPasswordDTO) throws Exception {
        usuarioServicio.cambiarPassword(cambiarPasswordDTO);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Password cambiado correctamente."));
    }

    @PutMapping("/{email}/activarCuenta")
    public ResponseEntity<MensajeDTO<String>> activarCuenta(@RequestBody ActivarCuentaDTO activarCuentaDTO) throws Exception {
        usuarioServicio.activarCuenta(activarCuentaDTO);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Activado correctamente."));
    }

    // Eliminación lógica de cuenta
    @DeleteMapping("/{id}eliminarCuenta")
    public ResponseEntity<MensajeDTO<String>> eliminar(@PathVariable String id) throws Exception {
        usuarioServicio.eliminar(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta eliminada correctamente."));
    }

}



