package co.edu.uniquindio.criminalReport.servicios;

import co.edu.uniquindio.criminalReport.dto.CambioPasswordConTokenDTO;
import co.edu.uniquindio.criminalReport.dto.LoginDTO;
import co.edu.uniquindio.criminalReport.dto.RecuperarPasswordDTO;
import co.edu.uniquindio.criminalReport.dto.TokenDTO;

public interface AutenticacionServicio {

   TokenDTO login(LoginDTO loginDTO) throws Exception;
   boolean recuperarPassword(RecuperarPasswordDTO recuperarPasswordDTO) throws Exception;
   String cambiarPasswordConToken(CambioPasswordConTokenDTO dto) throws Exception;
}
