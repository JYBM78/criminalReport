package co.edu.uniquindio.criminalReport.servicios.impl;

import co.edu.uniquindio.criminalReport.dto.LoginDTO;
import co.edu.uniquindio.criminalReport.dto.TokenDTO;
import co.edu.uniquindio.criminalReport.servicios.AutenticacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {
    @Override
    public TokenDTO login(LoginDTO login) throws Exception {
        return null;
    }
}
