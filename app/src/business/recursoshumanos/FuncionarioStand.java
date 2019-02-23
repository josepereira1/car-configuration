package business.recursoshumanos;

public class FuncionarioStand extends Utilizador{

    /**
     * Construtor vazio.
     */
    public FuncionarioStand(){
        super();
    }

    /**
     * Construtor parametrizado.
     * @param id id do funcionário do stand.
     * @param nome nome do funcionário do stand.
     * @param password password do funcionário da stand.
     */
    public FuncionarioStand(String id, String nome, String password){
        super(id,nome,password,1);
    }

    /**
     * Construtor cópia.
     * @param funcionarioStand funcionário do stand.
     */
    public FuncionarioStand(FuncionarioStand funcionarioStand){
        super(funcionarioStand);
    }

}
