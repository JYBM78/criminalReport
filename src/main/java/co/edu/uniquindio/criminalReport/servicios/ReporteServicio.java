package co.edu.uniquindio.criminalReport.servicios;

import co.edu.uniquindio.criminalReport.dto.*;
import co.edu.uniquindio.criminalReport.modelo.documents.Reporte;
import co.edu.uniquindio.criminalReport.modelo.enums.EstadoReporte;
import co.edu.uniquindio.criminalReport.modelo.validacion.Ubicacion;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;

public interface ReporteServicio {

    String crearReporte(@Valid CrearReporteDTO reporte) throws Exception;
    void eliminarReporte(String id) throws Exception;
    void actualizarReporte(String id, EditarReporteDTO reporte) throws Exception;
    ReporteDTO obtener(String id) throws Exception;
    void marcarImportante(String id) throws Exception;
    void cambiarEstadoReporte(String id, CambiarEstadoDTO estado) throws Exception;
    InfoReporteDTO obtenerReporte(String id) throws Exception;
    List<InfoReporteDTO> obtenerReportes(String categoria, EstadoReporte estadoReporte, int pagina) throws Exception;
    List<InfoReporteDTO> obtenerReportesUsuario(String idCliente, int pagina) throws Exception;
    List<InfoReporteDTO> obtenerReportes(Ubicacion ubicacion) throws Exception;
    List<HistorialEstadoDTO> listarHistorialEstados(String id) throws Exception;
    String activarBotonPanico(BotonPanicoDTO panicoDTO) throws Exception;

}

