package business.recursoshumanos;

public class Utilizador {
    private String id;
    private String nome;
    private String password;
    private int tipo;   //  -1 nenhum, 0 admin, 1 stand, 2 fábrica

    /**
     * Construtor vazio.
     */
    public Utilizador(){
        id = "";
        nome = "";
        password = "";
        tipo = -1;
    }

    /**
     * Contrutor parametrizado.
     * @param id id do utilizador.
     * @param nome nome do utilizador.
     * @param password password do utilizador.
     * @param tipo tipo de utilizador.
     */
    public Utilizador(String id, String nome, String password, int tipo) {
        this.id = id;
        this.nome = nome;
        this.password = password;
        this.tipo = tipo;
    }

    /**
     * Construtor cópia.
     * @param utilizador utilizador a copiar.
     */
    public Utilizador(Utilizador utilizador){
        nome = utilizador.getNome();
        password = utilizador.getPassword();
    }

    /**
     * Devolve o nome do utilizador.
     * @return retorna o nome do utilizador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Coloca o nome do utilizador.
     * @param nome nome do utilizador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve a password.
     * @return retorna a password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Coloca a password do utilizador.
     * @param password password do utilizador.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Devolve o id do utilizador.
     * @return retorna o tipo de utilizador.
     */
    public String getId() {
        return id;
    }

    /**
     * Coloca o id do utilizador.
     * @param id id do utilizador.
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     * Devolve o tipo de utilizador.
     * @return retorna o tipo de utilizador.
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Coloca o tipo de utilizador.
     * @param tipo tipo de utilizador.
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Faz uma cópia deste objeto.
     * @return retorna uma cópia deste objeto.
     */
    public Utilizador clone(){
        return new Utilizador(this);
    }

    /**
     * Testa a igualdade deste objeto com o objeto que recebe como parâmetro.
     * @param o objeto a testar
     * @return retorna o teste de igualdade entre este objeto e o objeto recebido como parâmetro.
     */
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null || this.getClass() != o.getClass())return false;

        Utilizador utilizador = (Utilizador) o;

        return id == utilizador.getId()
                && nome.equals(utilizador.getNome())
                && password.equals(utilizador.getPassword())
                && tipo == utilizador.getTipo();
    }

    /**
     * Coloca numa String toda a informação deste objeto.
     * @return retorna uma String com toda a informação deste objeto.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Utilizador={");
        sb.append("id=").append(id);
        sb.append(";nome=").append(nome);
        sb.append(";password=").append(password);
        sb.append(";tipo=").append(tipo).append("};");
        return sb.toString();
    }
}
