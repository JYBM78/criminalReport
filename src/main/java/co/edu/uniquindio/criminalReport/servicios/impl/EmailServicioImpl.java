package co.edu.uniquindio.criminalReport.servicios.impl;

import co.edu.uniquindio.criminalReport.dto.EmailDTO;
import co.edu.uniquindio.criminalReport.servicios.EmailServicio;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServicioImpl implements EmailServicio {

    private final JavaMailSender mailSender;

    @Override
    public void enviarCorreo(EmailDTO emailDTO) throws MessagingException {
        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);

        helper.setTo(emailDTO.email());
        helper.setSubject(emailDTO.asunto());
        helper.setText(emailDTO.mensaje(), false); // `false` para texto plano, `true` para HTML

        helper.setFrom("Criminal Report <hci.noche@gmail.com>"); // ¡Agregado!

        mailSender.send(mail);
    }
}
