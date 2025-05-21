package co.edu.uniquindio.criminalReport.servicios;


import org.springframework.web.multipart.MultipartFile;
import java.util.Map;


public interface ImagesServicio {


    Map subirImagen(MultipartFile images) throws Exception;

    Map eliminarImagen(String idImages) throws Exception;
}