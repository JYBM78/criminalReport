package co.edu.uniquindio.criminalReport.controladores;

import co.edu.uniquindio.criminalReport.dto.*;
import co.edu.uniquindio.criminalReport.servicios.ReporteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reportes")
public class ReporteControlador {

    private final ReporteServicio reporteServicio;

    // Crear un nuevo reporte
    @PostMapping
    public ResponseEntity<MensajeDTO<String>> crear(@Valid @RequestBody CrearReporteDTO reporte) throws Exception {
        reporteServicio.crearReporte(reporte);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Reporte creado exitosamente"));
    }

    // Editar un reporte existente
    @PutMapping("/{id}")
    public ResponseEntity<MensajeDTO<String>> editar(@PathVariable String id, @Valid @RequestBody EditarReporteDTO dto) throws Exception {
        reporteServicio.actualizarReporte(id, dto);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Reporte editado correctamente"));
    }
    

    // Eliminar un reporte
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) throws Exception {
        reporteServicio.eliminarReporte(id);
        return ResponseEntity.ok("Reporte eliminado correctamente");
    }

    // Obtener un reporte específico
    @GetMapping("/{id}")
    public ResponseEntity<ReporteDTO> obtener(@PathVariable String id) throws Exception {
        ReporteDTO reporte = reporteServicio.obtener(id);
        return ResponseEntity.ok(reporte);
    }

    // Marcar un reporte como importante
    @PutMapping("/{id}/importante")
    public ResponseEntity<String> marcarImportante(@PathVariable String id) throws Exception {
        reporteServicio.marcarImportante(id);
        return ResponseEntity.ok("Reporte marcado como importante");
    }

    // Cambiar el estado de un reporte
    @PutMapping("/{id}/estado/{nuevoEstado}")
    public ResponseEntity<String> cambiarEstado(@PathVariable String id, @PathVariable CambiarEstadoDTO cambiarEstadoDTO) throws Exception {
        reporteServicio.cambiarEstadoReporte(id, cambiarEstadoDTO);
        return ResponseEntity.ok("Estado del reporte actualizado a: " + cambiarEstadoDTO);
    }

    @PostMapping("/panico")
    public ResponseEntity<MensajeDTO<String>> activarBotonPanico(@RequestBody BotonPanicoDTO panicoDTO) throws Exception {
        String idReporte = reporteServicio.activarBotonPanico(panicoDTO);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Botón de pánico activado. ID del reporte: " + idReporte));
    }

}