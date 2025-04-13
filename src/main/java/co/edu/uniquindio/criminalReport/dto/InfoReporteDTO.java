package co.edu.uniquindio.criminalReport.dto;

import lombok.Data;

import java.time.LocalDateTime;
/*
public record InfoReporteDTO(
        String id,
        String titulo,
        String descripcion,
        String categoria,
        String ciudad,
        String estado,
        LocalDateTime fechaCreacion
){}
*/
@Data
public class InfoReporteDTO {
    private String id;
    private String titulo;
    private String descripcion;
    private String idCategoria;
    private String ubicacion;
    private String estadoActual;
    private LocalDateTime fecha;
    private int contadorImportante;

    public InfoReporteDTO(String id, String titulo, String descripcion, String idCategoria, String ubicacion, String estadoActual, LocalDateTime fecha, int contadorImportante) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.ubicacion = ubicacion;
        this.estadoActual = estadoActual;
        this.fecha = fecha;
        this.contadorImportante = contadorImportante;
    }
}
