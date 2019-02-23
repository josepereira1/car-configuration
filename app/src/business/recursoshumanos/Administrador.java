package business.recursoshumanos;

public class Administrador extends Utilizador{

    /**
     * Construtor vazio.
     */
    public Administrador(){
        super();
    }

    /**
     * Construtor parametrizado.
     * @param id id do adminstrador
     * @param nome nome do administrador
     * @param password password do administrador
     */
    public Administrador(String id, String nome, String password){
        super(id,nome, password,0);
    }

    /**
     * Construtor cópia.
     * @param administrador administrador que vai ser copiado.
     */
    public Administrador(Administrador administrador){
        super(administrador);
    }
}
