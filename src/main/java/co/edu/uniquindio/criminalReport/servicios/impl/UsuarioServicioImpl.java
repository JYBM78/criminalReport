package co.edu.uniquindio.criminalReport.servicios.impl;

import co.edu.uniquindio.criminalReport.dto.CrearUsuarioDTO;
import co.edu.uniquindio.criminalReport.dto.EditarUsuarioDTO;
import co.edu.uniquindio.criminalReport.dto.UsuarioDTO;
import co.edu.uniquindio.criminalReport.modelo.Usuario;
import co.edu.uniquindio.criminalReport.repositorios.UsuarioRepositorio;
import co.edu.uniquindio.criminalReport.servicios.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    @Override
    public void crear(CrearUsuarioDTO cuenta) throws Exception {
        if (usuarioRepositorio.findByEmail(cuenta.email()).isPresent()) {
            throw new Exception("El correo ya está registrado");
        }
        //TODO Aqui se debe implementar la logica de creacion de un usuario
        Usuario usuario = Usuario.builder()
                //.id(UUID.randomUUID().toString()) //para asignar id automáticos
                .id(cuenta.id())
                .nombre(cuenta.nombre())
                .email(cuenta.email())
                .password(cuenta.password()) // Encriptar en el futuro
                .ciudad(cuenta.ciudad())
                .direccion(cuenta.direccion())
                .activo(true)
                .build();
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminar(String id) throws Exception {
        //TODO Aqui se debe implementar la logica de eliminacion de un usuario
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        if (usuario.isEmpty()) {
            throw new Exception("Usuario no encontrado");
        }
        Usuario u = usuario.get();
        u.setActivo(false); // Eliminación lógica
        usuarioRepositorio.save(u);
    }

    @Override
    public void editar(EditarUsuarioDTO cuenta) throws Exception {
        //TODO Aqui se debe implementar la logica de edicion de un usuario
        Optional<Usuario> usuarioOpt = usuarioRepositorio.findById(cuenta.id());
        if (usuarioOpt.isEmpty()) {
            throw new Exception("Usuario no encontrado");
        }
        Usuario usuario = usuarioOpt.get();
        usuario.setNombre(cuenta.nombre());
        usuario.setCiudad(cuenta.ciudad());
        usuario.setDireccion(cuenta.direccion());
        usuarioRepositorio.save(usuario);
    }

    @Override
    public UsuarioDTO obtener(String id) throws Exception {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
        return new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getCiudad(), usuario.getDireccion(), usuario.getEmail());

        //TODO Aqui se debe implementar la logica de obtencion de un usuario
        /*
        return new UsuarioDTO(
             UUID.randomUUID().toString(),
             "Yovany",
             "Armenia",
             "Calle 123",
             "yovany@email.com"
         );
        */
    }

    @Override
    public List<UsuarioDTO> listarTodos(String nombre, String ciudad) {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarios.stream()
                .filter(u -> u.isActivo())
                .filter(u -> nombre == null || u.getNombre().contains(nombre))
                .filter(u -> ciudad == null || u.getCiudad().equalsIgnoreCase(ciudad))
                .map(u -> new UsuarioDTO(u.getId(), u.getNombre(), u.getCiudad(), u.getDireccion(), u.getEmail()))
                .collect(Collectors.toList());

        //TODO Aqui se debe implementar la logica de listado de usuarios y filtrado por nombre y ciudad
        /*
        return List.of(
            new UsuarioDTO(
                UUID.randomUUID().toString(),
                "Yovany",
                "Armenia",
                "Calle 123",
                "yovany@email.com"),
            new UsuarioDTO(
                UUID.randomUUID().toString(),
                "Daniela",
                "Tuluá",
                "Calle 123",
                "daniela@email.com"),
            new UsuarioDTO(
                UUID.randomUUID().toString(),
                "Esperanza",
                "Belalcázar",
                "Calle 123",
                "esperanza@email.com")
        );
        */

    }
}
