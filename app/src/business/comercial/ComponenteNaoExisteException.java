package business.comercial;

public class ComponenteNaoExisteException extends Exception {

    public ComponenteNaoExisteException() {
    }

    public ComponenteNaoExisteException(String message) {
        super(message);
    }
}
