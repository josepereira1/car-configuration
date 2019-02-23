package business.comercial;

public class PacoteNaoExisteException extends Exception {

    public PacoteNaoExisteException() {
    }

    public PacoteNaoExisteException(String message) {
        super(message);
    }
}
