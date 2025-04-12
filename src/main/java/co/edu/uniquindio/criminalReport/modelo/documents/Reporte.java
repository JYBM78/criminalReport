package co.edu.uniquindio.criminalReport.modelo.documents;

import co.edu.uniquindio.criminalReport.modelo.enums.EstadoReporte;
import co.edu.uniquindio.criminalReport.modelo.validacion.HistorialReporte;
import co.edu.uniquindio.criminalReport.modelo.validacion.Ubicacion;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("reportes")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(toBuilder = true)
public class Reporte {

    @Id
    @EqualsAndHashCode.Include
    private ObjectId id;
    
    private String titulo;
    private ObjectId idCategoria;
    private String descripcion;
    private Ubicacion ubicacion;
    private List<String> fotos;
    private String idCliente; // Referencia al usuario que creó el reporte
    private LocalDateTime fecha;
    private List<HistorialReporte> historial;
    private EstadoReporte estadoActual;
    private int contadorImportante;

    @Builder
    public Reporte(ObjectId id, String titulo, ObjectId idCategoria, String descripcion, Ubicacion ubicacion, List<String> fotos, String idCliente, LocalDateTime fecha, List<HistorialReporte> historial, EstadoReporte estadoActual, int contadorImportante) {
        this.id = id;
        this.titulo = titulo;
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.fotos = fotos;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.historial = historial;
        this.estadoActual = estadoActual;
        this.contadorImportante = contadorImportante;
    }
}