package co.edu.uniquindio.criminalReport.excepciones;

public class TokenExpiradoException extends RuntimeException {
    public TokenExpiradoException(String mensaje) {
        super(mensaje);
    }
}
