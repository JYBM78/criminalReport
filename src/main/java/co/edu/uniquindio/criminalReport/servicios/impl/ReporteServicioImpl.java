package co.edu.uniquindio.criminalReport.servicios.impl;

import co.edu.uniquindio.criminalReport.dto.*;
import co.edu.uniquindio.criminalReport.mapper.ReporteMapper;
import co.edu.uniquindio.criminalReport.modelo.documents.Reporte;
import co.edu.uniquindio.criminalReport.modelo.documents.Usuario;
import co.edu.uniquindio.criminalReport.modelo.enums.EstadoReporte;
import co.edu.uniquindio.criminalReport.modelo.enums.EstadoUsuario;
import co.edu.uniquindio.criminalReport.modelo.validacion.Ubicacion;
import co.edu.uniquindio.criminalReport.repositorios.ReporteRepositorio;
import co.edu.uniquindio.criminalReport.repositorios.UsuarioRepositorio;
import co.edu.uniquindio.criminalReport.servicios.ReporteServicio;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReporteServicioImpl implements ReporteServicio {


    private final ReporteRepositorio reporteRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;
    private final ReporteMapper reporteMapper;
    private final WebSocketNotificationService webSocketNotificationService;

    @Override
    public String crearReporte(CrearReporteDTO dto) {
        // Buscar usuario o lanzar excepción personalizada
        Usuario usuario = obtenerClienteActivo(dto.idCliente());

        // Crear el documento Reporte a partir del DTO
        Reporte reporte = reporteMapper.toDocument(dto);
        asignarDatosAdicionales(reporte);
        reporte.setFecha(LocalDateTime.now()); // nuevo 12/04/25
        reporte.setEstadoActual(EstadoReporte.PENDIENTE); // nuevo 12/04/25

        // Guardar el reporte en la base de datos
        reporteRepositorio.save(reporte);

        // Enviar notificación por WebSocket
        notificarNuevoReporte(reporte);

        // nuevo 12/04/25

        // Aumentar el contador de reportes
        usuario.setCantidadReportes(usuario.getCantidadReportes() + 1);
        usuarioRepositorio.save(usuario);

        // Retornar el ID del reporte creado
        return reporte.getId().toHexString();

    }



    @Override
    public void actualizarReporte(String id, EditarReporteDTO dto) throws Exception {
        // Validar que el ID tenga un formato correcto
        if (!ObjectId.isValid(id)) {
            throw new IllegalArgumentException("El ID proporcionado no es válido: " + id);
        }
        ObjectId objectId = new ObjectId(id);
        // Buscar el reporte existente
        Reporte reporteExistente = reporteRepositorio.findById(objectId)
                .orElseThrow(() -> new NoSuchElementException("No se encontró un reporte con el id: " + id));
        // Utilizar el mapper para actualizar el documento existente
        reporteMapper.editarReporteDTO(dto, reporteExistente);
        // Guardar los cambios
        reporteRepositorio.save(reporteExistente);
        // Notificar por WebSocket
        NotificacionDTO notificacionDTO = new NotificacionDTO(
                "Actualización de Reporte",
                "Reporte actualizado: " + reporteExistente.getTitulo(),
                "reportes"
        );
        webSocketNotificationService.notificarClientes(notificacionDTO);
    }

    @Override
    public void eliminarReporte(String id) {
        // Validar el ID
        if (!ObjectId.isValid(id)) {
            throw new IllegalArgumentException("ID incorrecto: " + id);
        }
        // Buscar el reporte por ID
        ObjectId objectId = new ObjectId(id);
        Optional<Reporte> optionalReporte = reporteRepositorio.findById(objectId);
        if (optionalReporte.isEmpty()) {
            throw new NoSuchElementException("No se encontró un reporte con el id: " + id);
        }
        Reporte reporte = optionalReporte.get();
        reporte.setEstadoActual(EstadoReporte.ELIMINADO);

        reporteRepositorio.save(reporte);
        // Notificar por WebSocket que se eliminó un reporte (opcional, pero recomendable)
        NotificacionDTO notificacionDTO = new NotificacionDTO(
                "Eliminación de Reporte",
                "Reporte eliminado: " + reporte.getTitulo(),
                "reportes"
        );
        webSocketNotificationService.notificarClientes(notificacionDTO);
    }

    @Override
    public ReporteDTO obtener(String id) {
        // Validar que el ID tenga formato correcto
        if (!ObjectId.isValid(id)) {
            throw new IllegalArgumentException("El ID no es válido: " + id);
        }
        ObjectId objectId = new ObjectId(id);
        // Buscar el reporte por ID
        Reporte reporte = reporteRepositorio.findById(objectId)
                .orElseThrow(() -> new NoSuchElementException("No se encontró un reporte con el id: " + id));
        // Convertir el documento a DTO usando el mapper
        return reporteMapper.toDTO(reporte);
    }

    @Override
    public void marcarImportante(String id) {

    }

    @Override
    public void cambiarEstadoReporte(String id, CambiarEstadoDTO cambiarEstadoDTO) throws Exception {
        // Validar que el ID tenga formato correcto
        if (!ObjectId.isValid(id)) {
            throw new IllegalArgumentException("El ID del reporte no es válido: " + id);
        }

        // Buscar el reporte por ID
        Reporte reporte = reporteRepositorio.findById(new ObjectId(id))
                .orElseThrow(() -> new NoSuchElementException("No se encontró un reporte con el id: " + id));

        // Cambiar el estado del reporte
        reporte.setEstadoActual(cambiarEstadoDTO.nuevoEstado());

        // Guardar los cambios
        reporteRepositorio.save(reporte);

        // Notificar si es necesario
        NotificacionDTO notificacion = new NotificacionDTO(
                "Cambio de Estado",
                "El estado del reporte ha sido actualizado a: " + cambiarEstadoDTO.nuevoEstado(),
                "reportes"
        );
        webSocketNotificationService.notificarClientes(notificacion);
    }


    @Override
    public InfoReporteDTO obtenerReporte(String id) throws Exception {
        return null;
    }

    @Override
    public List<InfoReporteDTO> obtenerReportes(String categoria, EstadoReporte estadoReporte, int pagina) throws Exception {
        return List.of();
    }

    @Override
    public List<InfoReporteDTO> obtenerReportesUsuario(String idCliente, int pagina) throws Exception {
        return List.of();
    }

    @Override
    public List<InfoReporteDTO> obtenerReportes(Ubicacion ubicacion) throws Exception {
        return List.of();
    }

    @Override
    public List<HistorialEstadoDTO> listarHistorialEstados(String id) throws Exception {
        return List.of();
    }

    @Override
    public String activarBotonPanico(BotonPanicoDTO panicoDTO) throws Exception {
        // Validar usuario
        Usuario cliente = obtenerClienteActivo(panicoDTO.idCliente());

        // Crear un reporte rápido con información básica
        Reporte reporte = Reporte.builder()
                .id(new ObjectId()) // asignación manual del id
                .titulo("¡Alerta de emergencia!")
                .descripcion("Botón de pánico activado por el cliente.")
                .fecha(LocalDateTime.now())
                .estadoActual(EstadoReporte.PENDIENTE)
                .idCliente(cliente.getId())
                //.idCliente(cliente.getId()) // Error: incompatible types: String cannot be converted to ObjectId
                .contadorImportante(1) // Para que se resalte como importante
                .build();

        // Asignar ubicación con latitud y longitud desde el DTO
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setLatitud(panicoDTO.latitud());
        ubicacion.setLongitud(panicoDTO.longitud());
        reporte.setUbicacion(ubicacion);

        // Guardar el reporte
        reporteRepositorio.save(reporte);

        // Notificar a los clientes (ej: admin o moderadores)
        NotificacionDTO notificacionDTO = new NotificacionDTO(
                "Emergencia detectada",
                "Un cliente activó el botón de pánico",
                "reportes"
        );
        webSocketNotificationService.notificarClientes(notificacionDTO);

        // Retornar el ID del nuevo reporte para seguimiento
        return reporte.getId().toHexString();
    }


    // Métodos auxiliares

    private Usuario obtenerClienteActivo(String idCliente) {
        return usuarioRepositorio.findById(idCliente)
                .filter(usuario -> usuario.getEstado() != EstadoUsuario.ELIMINADO)
                .orElseThrow(() -> new RuntimeException("Usuario inexistente o inactivo"));
    }

    private void asignarDatosAdicionales(Reporte reporte) {
        reporte.setEstadoActual(EstadoReporte.PENDIENTE);
        reporte.setFecha(LocalDateTime.now());
        reporte.setContadorImportante(0);
    }

    private void notificarNuevoReporte(Reporte reporte) {
        NotificacionDTO notificacionDTO = new NotificacionDTO(
                "Nuevo Reporte",
                "Nuevo reporte creado: " + reporte.getTitulo(),
                "reportes"
        );
        webSocketNotificationService.notificarClientes(notificacionDTO);
    }
}



