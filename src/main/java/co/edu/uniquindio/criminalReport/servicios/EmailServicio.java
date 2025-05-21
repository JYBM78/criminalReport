package co.edu.uniquindio.criminalReport.servicios;

import co.edu.uniquindio.criminalReport.dto.EmailDTO;
import jakarta.mail.MessagingException;

public interface EmailServicio {
    void enviarCorreo(EmailDTO emailDTO) throws MessagingException;
}
