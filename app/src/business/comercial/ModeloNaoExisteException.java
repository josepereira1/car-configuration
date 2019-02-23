package business.comercial;

public class ModeloNaoExisteException extends Exception {

    public ModeloNaoExisteException() {
    }

    public ModeloNaoExisteException(String message) {
        super(message);
    }
}
