/*
package co.edu.uniquindio.criminalReport.controladores;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController // indica que esta clase es un controlador REST, lo que significa que manejará solicitudes HTTP y devolverá respuestas en formato de texto o JSON
@RequiredArgsConstructor // anotación para que esta variable se inicialice
@RequestMapping("/saludo") // prefijo común para todas las rutas del controlador. Para que todas las rutas comiencen con /saludo. Esto permite que las rutas queden más organizadas y evitamos posibles conflictos con otras rutas en la aplicación.

public class SaludoControlador {

    @GetMapping// Especifica que los métodos dentro del controlador responderán a solicitudes HTTP GET.
    public String saludar(){
        return "Hola, bienvenido a la aplicación GET";
    }

    @GetMapping("/{nombre}")
    public String saludarNombre(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @PostMapping("/saludar")
    public String saludarPost() {
        return "Hola , bienvenido a la aplicación POST";
    }

}
/*
NOTA: Los métodos del controlador debe ser equivalente a los métodos del servicio de
los usuarios (tanto en su retorno, su nombre, sus excepciones y sus parámetros).
Es necesario crear DTO que encapsulan los datos tanto de entrada como de salida de
la API. Estos DTO deben estar en el paquete: co.edu.uniquindio.proyecto.dto.
 */