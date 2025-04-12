package co.edu.uniquindio.criminalReport.servicios.impl;

import co.edu.uniquindio.criminalReport.dto.*;
import co.edu.uniquindio.criminalReport.excepciones.RecursoNoEncontradoException;
import co.edu.uniquindio.criminalReport.mapper.UsuarioMapper;
import co.edu.uniquindio.criminalReport.modelo.documents.Usuario;
import co.edu.uniquindio.criminalReport.modelo.enums.EstadoUsuario;
import co.edu.uniquindio.criminalReport.modelo.validacion.CodigoValidacion;
import co.edu.uniquindio.criminalReport.repositorios.UsuarioRepositorio;
import co.edu.uniquindio.criminalReport.servicios.EmailServicio;
import co.edu.uniquindio.criminalReport.servicios.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;
    private final UsuarioMapper usuarioMapper;
    private final MongoTemplate mongoTemplate;
    private final EmailServicio emailServicio;



    @Override
    public void crear(CrearUsuarioDTO crearUsuarioDTO) throws Exception {
        if( existeEmail(crearUsuarioDTO.email()) ){
            throw new Exception("El email "+crearUsuarioDTO.email()+" ya está en uso");
        }
        Usuario usuario = usuarioMapper.toDocument(crearUsuarioDTO);
        String codigoActivacion = generarCodigo();
        usuario.setCodigoValidacion(new CodigoValidacion(
                codigoActivacion,
                LocalDateTime.now()
        ));
        usuarioRepositorio.save(usuario);
        String asunto = "Activar cuenta";
        String destinatario = usuario.getEmail(); // Se declara el destinatario

        String cuerpo = """
                <html>
                      <body style="font-family: 'Segoe UI', sans-serif; background-color: #1e1e2f; padding: 40px; color: #ffffff;">
                        <div style="max-width: 600px; margin: auto; background-color: #2c2c3e; padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.4);">
                          <h2 style="color: #00bcd4; text-align: center;">Activación de Cuenta</h2>
                          <p style="font-size: 16px;">Hola <strong>%s</strong>,</p>
                          <p>Gracias por registrarte en <strong>Criminal Report</strong>. Tu código de verificación es:</p>
                          <div style="background-color: #111827; padding: 20px; border-radius: 6px; text-align: center; margin: 20px 0;">
                            <span style="font-size: 24px; color: #00e5ff;"><strong>%s</strong></span>
                          </div>
                          <p style="font-size: 14px;">Este código expirará en 15 minutos. ¿No solicitaste este código?, Verifica tu cuenta o ignora este mensaje.</p>
                          <p style="margin-top: 40px; font-size: 12px; color: #aaaaaa; text-align: center;">Este es un correo automático. Por favor no lo respondas.</p>
                        </div>
                      </body>
                    </html>
        """.formatted(usuario.getNombre(), codigoActivacion);
        emailServicio.enviarCorreo(new EmailDTO(asunto, cuerpo, destinatario));

    }

    @Override
    public void editar(String id,EditarUsuarioDTO editarUsuarioDTO) throws Exception {
        Usuario usuario = obtenerUsuarioPorId(id);
        usuarioMapper.editarUsuarioDTO(editarUsuarioDTO, usuario);
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminar(String id) throws Exception {

        Usuario usuario = obtenerUsuarioPorId(id);
        usuario.setEstado(EstadoUsuario.ELIMINADO);
        usuarioRepositorio.save(usuario);
    }

    @Override
    public UsuarioDTO obtener(String id) throws Exception {
        Usuario usuario = obtenerUsuarioPorId(id);
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public  List<UsuarioDTO> listarTodos(String nombre, String ciudad, int pagina) {
        if(pagina < 0) throw new RuntimeException("La página no puede ser menor a 0");
        // Crear criterios dinámicos
        Criteria criteria = new Criteria();
        if (nombre != null && !nombre.isEmpty()) {
            criteria.and("nombre").regex(nombre, "i"); // Ignora a mayúsculas/minúsculas
        }
        if (ciudad!= null && !ciudad.isEmpty()) {
            criteria.and("ciudad").regex(ciudad, "i");
        }
        // Crear la consulta con los criterios y la paginación de 5 elementos por página
        Query query = new Query(criteria).with(PageRequest.of(pagina, 5));
        List<Usuario> usuarios = mongoTemplate.find(query, Usuario.class);
        // Convertir la lista de usuarios a una lista de DTOs
        return usuarios.stream()
                .map(usuarioMapper::toDTO)
                .toList();
    }

    @Override
    public List<InfoReporteDTO> obtenerReportesUsuario(String id) {

        return null;
    }

    private boolean existeEmail(String email) {
        return usuarioRepositorio.findByEmail(email).isPresent();
    }

    //Metodo utilizado en crear, editar y eliminar (Metodo de apoyo para no repetir codigo)
    private Usuario obtenerUsuarioPorId(String id) throws Exception {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró el usuario con el id " + id));
    }

    //Metodo usado en activarCuenta y cambiarPassword para obtener el usuario por email
    private Usuario obtenerPorEmail(String email) throws RecursoNoEncontradoException {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findByEmail(email);
        if (usuarioOptional.isEmpty()) {
            throw new RecursoNoEncontradoException("No se encontró el usuario con el email " + email);
        }
        return usuarioOptional.get();
    }

    private String generarCodigo() {
        String digitos = "0123456789";
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int indice = (int) (Math.random() * digitos.length());
            codigo.append(digitos.charAt(indice));
        }
        return codigo.toString();
    }

    //Envia el codigo para cambiar password
    @Override
    public void enviarCodigoVerificacion(EnviarCodigoDTO enviarCodigoDTO) throws Exception {
        Usuario usuario = obtenerPorEmail(enviarCodigoDTO.email());
        String codigo = generarCodigo();
        usuario.setCodigoValidacion(new CodigoValidacion(
                codigo,
                LocalDateTime.now()
        ));
        usuarioRepositorio.save(usuario);
        String asunto = "Restablecer Password";
        String cuerpo = "¡Este " + usuario.getNombre() + "! es el código para cambiar tu password: " + codigo;
        String destinatario = usuario.getEmail();
        emailServicio.enviarCorreo(new EmailDTO(asunto, cuerpo, destinatario));
    }

    @Override
    public void cambiarPassword(CambiarPasswordDTO cambiarPasswordDTO) throws Exception {
        Usuario usuario = obtenerPorEmail(cambiarPasswordDTO.email());
        if(!usuario.getCodigoValidacion().getCodigo().equals(cambiarPasswordDTO.codigoValidacion())) {
            throw new Exception("Código de verificación incorrecto");
        }
        if (usuario.getCodigoValidacion() == null) {
            throw new Exception("El usuario no tiene un código de verificación");
        }
        if(!LocalDateTime.now().isBefore(usuario.getCodigoValidacion().getFechaCreacion().plusMinutes(15))) {
            throw new Exception("Código de verificación expirado");
        }
        usuario.setPassword(cambiarPasswordDTO.nuevaPassword());
        usuario.setCodigoValidacion(null);
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void activarCuenta(ActivarCuentaDTO activarCuentaDTO) throws Exception {
        Usuario usuario = obtenerPorEmail(activarCuentaDTO.email());
        if(!usuario.getCodigoValidacion().getCodigo().equals(activarCuentaDTO.codigoValidacion())) {
            throw new Exception("Código de verificación incorrecto");
        }
        if(!LocalDateTime.now().isBefore(usuario.getCodigoValidacion().getFechaCreacion().plusMinutes(15))) {
            throw new Exception("Código de verificación expirado");
        }
        if (usuario.getCodigoValidacion() == null) {
            throw new Exception("No se encontró el usuario con el email ");
        }
        usuario.setEstado(EstadoUsuario.ACTIVO);
        usuario.setCodigoValidacion(null);
        usuarioRepositorio.save(usuario);
    }



}
