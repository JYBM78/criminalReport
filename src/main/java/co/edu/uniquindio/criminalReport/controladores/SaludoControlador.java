package co.edu.uniquindio.criminalReport.controladores;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
/*
Indica que esta clase es un controlador REST, lo que significa
que manejará solicitudes HTTP y devolverá respuestas en formato de texto o JSON
 */
@RequestMapping("/saludo") // Prefijo común para todas las rutas del controlador
public class SaludoControlador {

    @GetMapping("/saludar")// Especifica que los métodos dentro del controlador responderán a solicitudes HTTP GET.
    public String saludar(){
        return "Hola, bienvenido a la aplicación GET";
    }

    @GetMapping("/{nombre}")
    public String saludarNombre(@PathVariable String nombre){
        return "Hola " + nombre;
    }


    @PostMapping("/saludar")
    public String saludarPost(){
        return "Hola , bienvenido a la aplicación POST";
    }

}
