package co.edu.uniquindio.criminalReport.servicios;

/*
La idea es que esta interface tenga la definición de los métodos
que deben ser implementados con su respectiva lógica de negocio.
 */

import co.edu.uniquindio.criminalReport.dto.CrearUsuarioDTO;
import co.edu.uniquindio.criminalReport.dto.EditarUsuarioDTO;
import co.edu.uniquindio.criminalReport.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioServicio {

    void crear(CrearUsuarioDTO cuenta) throws Exception;
    void eliminar(String id) throws Exception;
    void editar(EditarUsuarioDTO cuenta) throws Exception;
    UsuarioDTO obtener(String id) throws Exception;
    List<UsuarioDTO> listarTodos(String nombre, String ciudad);

}
