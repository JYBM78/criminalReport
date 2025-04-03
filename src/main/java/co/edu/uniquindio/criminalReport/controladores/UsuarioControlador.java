package co.edu.uniquindio.criminalReport.controladores;

import co.edu.uniquindio.criminalReport.dto.CrearUsuarioDTO;
import co.edu.uniquindio.criminalReport.dto.EditarUsuarioDTO;
import co.edu.uniquindio.criminalReport.dto.MensajeDTO;
import co.edu.uniquindio.criminalReport.dto.UsuarioDTO;
import co.edu.uniquindio.criminalReport.servicios.UsuarioServicio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios") // cuando se pida la url http://localhost:8080/api/usuarios será el controlador REST que estamos programando quien responda ante las peticiones realizadas.
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio; // Variable de tipo UsuarioServicio, para que funcione la interface UsuarioiServicio, con la definición de los métodos implemenmtados en la lógica del negocio.

    /*
    métodos para cada servicio de negocio de los usuarios que sea pertinente para la API.
    A manera de ejemplo se hará el controlador implementando solamente los métodos para hacer un CRUD básico en la entidad.
     */
    @PostMapping
    public ResponseEntity<MensajeDTO<String>> crear(@Valid @RequestBody CrearUsuarioDTO cuenta) throws Exception{
        usuarioServicio.crear(cuenta);
        return ResponseEntity.status(201).body(new MensajeDTO<>(false, "Su registro ha sido exitoso"));
    }
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/{id}")
    public ResponseEntity<MensajeDTO<UsuarioDTO>> obtener(@PathVariable String id) throws Exception{
        UsuarioDTO info = usuarioServicio.obtener(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, info));
    }

    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminar(@PathVariable String id) throws Exception{
        usuarioServicio.eliminar(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta eliminada exitosamente"));
    }

    @GetMapping
    public ResponseEntity<MensajeDTO<List<UsuarioDTO>>> listarTodos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String ciudad
    ){
        List<UsuarioDTO> lista = usuarioServicio.listarTodos(nombre, ciudad);
        return ResponseEntity.ok(new MensajeDTO<>(false, lista));
    }

    @SecurityRequirement(name = "bearerAuth")
    @PutMapping
    public ResponseEntity<MensajeDTO<String>> editarCuenta(@Valid @RequestBody EditarUsuarioDTO cuenta) throws Exception{
        usuarioServicio.editar(cuenta);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta editada exitosamente"));
    }


}



