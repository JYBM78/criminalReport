package co.edu.uniquindio.criminalReport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
Las anotaciones en SpringBoot nos permiten para crear entidades,
configurar validaciones, para crear servicios, crear la API,
para especificar cómo llegan los datos a las APIs.
 */
@SpringBootApplication // Anotación que marca esta clase como la clase de acceso
public class CriminalReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriminalReportApplication.class, args); // Clase que ejecuta el metodo .run y recibe por parámetro la clase donde está ubicado el main y los argumentos en caso que existan

    }
}
/*
Al ejecutar es importante visualizar enm la consola "Tomcat initialized with port 8080 (http)"
Tomcat es un servidor HTTP, significa que localmente ya hay un servidor HTTP
que recibe y responde mensajes, esto se debe al uso de frameworks, incluso sin descargar
Tomcat, porque Springboot al ejecutar el proyecto tiene embebida a la app.
Para hacerle peticiones al servidor, para acceder a la máquina se usa la dirección  127.0.0.1,
que equivale al nombre Localhost: 8080
No importa el puerto que use siempre y cuando esté libre.
 */