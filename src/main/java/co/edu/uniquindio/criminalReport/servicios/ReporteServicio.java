package co.edu.uniquindio.criminalReport.servicios;

import co.edu.uniquindio.criminalReport.dto.*;
import co.edu.uniquindio.criminalReport.modelo.documentos.Reporte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface ReporteServicio {


    Reporte crearReporte(CrearReporteDTO crearReporteDTO) throws Exception;

    void eliminarReporte(String id)  throws Exception;

    void editarReporte(String idReporte, EditarReporteDTO dto) throws Exception;

    Reporte obtenerReportePorId(String id) throws Exception;

    Page<Reporte> listarReportes(Pageable pageable);

    boolean marcarImportante(String idReporte) throws  Exception;

    boolean cambiarEstado(String idReporte, EstadoReporteDTO estadoReporteDTO) throws Exception;

    List<ReporteDTO> listarReportesPorCategoriaYFechas(String categoria, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    byte[] generarInformePDF(String categoria, LocalDateTime fechaInicio, LocalDateTime fechaFin) throws  Exception;

    Page<Reporte> obtenerReportesCercanos(double longitud, double latitud, Pageable pageable);



    List<ReporteDTO> buscarReportes(BuscarReporteDTO filtros) throws Exception;



    List<ReporteDTO> obtenerReportesPorUsuario() throws Exception;



    }
