package co.edu.uniquindio.criminalReport.servicios;

import co.edu.uniquindio.criminalReport.dto.LoginDTO;
import co.edu.uniquindio.criminalReport.dto.TokenDTO;
import jakarta.validation.Valid;

public interface AutenticacionServicio {

    TokenDTO login(@Valid LoginDTO login) throws Exception;
}
