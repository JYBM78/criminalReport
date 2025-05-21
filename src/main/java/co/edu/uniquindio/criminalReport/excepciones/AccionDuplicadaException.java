package co.edu.uniquindio.criminalReport.excepciones;

public class AccionDuplicadaException extends RuntimeException {
    public AccionDuplicadaException(String mensaje) {
        super(mensaje);
    }
}