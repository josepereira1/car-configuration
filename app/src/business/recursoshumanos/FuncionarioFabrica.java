package business.recursoshumanos;



public class FuncionarioFabrica extends Utilizador {

    /**
     * Construtor vazio.
     */
    public FuncionarioFabrica(){
        super();
    }

    /**
     * Construtor parametrizado.
     * @param id id do funcionário da fábrica.
     * @param nome nome do funcionário da fábrica.
     * @param password password do funcionário da fábrica.
     */
    public FuncionarioFabrica(String id, String nome, String password){
        super(id, nome,password,2);
    }

    /**
     * Construtor cópia.
     * @param funcionarioFabrica funcionário da fábrica.
     */
    public FuncionarioFabrica(FuncionarioFabrica funcionarioFabrica){
        super(funcionarioFabrica);
    }
}
