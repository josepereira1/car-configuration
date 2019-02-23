package business.comercial;

import java.util.*;

public class Configuracao {

    private String id;
    private String modelo;
    private String motor;
    private Set<String> interiores;
    private Set<String> exteriores;
    private Set<String> pacotes;
    private float preco;
    private float desconto; // 0 <= d <= 1
    private String utilizador; // Quem criou a configuracao
    private boolean valida;

    /**
     * Cria uma configuracao vazia.
     */
    public Configuracao() {
        this.id = "";
        this.modelo = "-1";
        this.motor = "-1";
        this.interiores = new TreeSet<>();
        this.exteriores = new TreeSet<>();
        this.pacotes = new TreeSet<>();
        this.preco = 0f;
        this.desconto = 0f;
        this.utilizador = "-1";
        this.valida = false;
    }

    /**
     * Construtor parametrizado.
     * @param id identificador da configuração
     * @param modelo identificador do modelo
     * @param motor identificador dor motor
     * @param interiores identificadores dos interiores
     * @param exteriores identificadores de exteriores
     * @param pacotes identificadores de pacotes
     * @param preco identificador de preco
     * @param desconto desconto da configuração
     * @param utilizador identificador do utilizdaor
     * @param valida indicador se configuração está pronta a produzir
     */
    public Configuracao(String id, String modelo, String motor, Set<String> interiores, Set<String> exteriores, Set<String> pacotes, float preco, float desconto, String utilizador, boolean valida) {
        this.setId(id);
        this.setModelo(modelo);
        this.setMotor(motor);
        this.setInteriores(interiores);
        this.setExteriores(exteriores);
        this.setPacotes(pacotes);
        this.setPreco(preco);
        this.setDesconto(desconto);
        this.setUtilizador(utilizador);
        this.setValida(valida);
    }

    /**
     * Construtor cópia.
     * @param c Configuração a ser copiada.
     */
    public Configuracao(Configuracao c) {
        this.id = c.getId();
        this.modelo = c.getModelo();
        this.motor = c.getMotor();
        this.interiores = c.getInteriores();
        this.exteriores = c.getExteriores();
        this.pacotes = c.getPacotes();
        this.preco = c.getPreco();
        this.desconto = c.getDesconto();
        this.utilizador = c.getUtilizador();
        this.valida = c.isValida();
    }

    /**
     * Devolve o identificador do modelo.
     * @return retorna o identificador do modelo.
     */
    public String getModelo() {
        return modelo;
    }
    
    /**
     * Define o modelo.
     * @param m modelo.
     */
    public void setModelo(Modelo m) {
        if (this.modelo.equals("-1")) {
            this.modelo = m.getId();
            this.preco += m.getPreco();
        }
    }

    /**
     * Define o modelo.
     * @param modelo identificador do modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devolve o identificador da configuracao.
     * @return retorna o id.
     */
    public String getId() {
        return id;
    }

    /**
     * Define o id da configuração.
     * @param id identificador da configuração.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Devolve o identificador do motor.
     * @return retorna o id do motor.
     */
    public String getMotor() {
        return motor;
    }
    
    /**
     * Define o id do motor.
     * @param motor identificador do motor.
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setMotor(Componente motor) {
        if (this.motor.equals("-1")) {
            this.motor = motor.getId();
            this.preco += motor.getPreco();
        }
    }

    /**
     * Devolve os identificadores dos interiores.
     * @return retorna os ids.
     */
    public Set<String> getInteriores() {
        return new TreeSet<>(interiores);
    }

    /**
     * Define os identificadores dos interiores.
     * @param interiores ids dos interiores
     */
    public void setInteriores(Set<String> interiores) {
        this.interiores = new TreeSet<>(interiores);
    }

    /**
     * Devolve os identificadores dos exteriores.
     * @return retorna os ids dos exteriores.
     */
    public Set<String> getExteriores() {
        return new TreeSet<>(exteriores);
    }

    /**
     * Define os identifcadores dos exteriores.
     * @param exteriores identificadores dos exteriores.
     */
    public void setExteriores(Set<String> exteriores) {
        this.exteriores = new TreeSet<>(exteriores);
    }

    /**
     * Devolve os identificadores dos pacotes.
     * @return retorna os ids dos pacotes.
     */
    public Set<String> getPacotes() {
        return new TreeSet<>(pacotes);
    }

    /**
     * Define os ids dos pacotes.
     * @param pacote ids dos pacotes
     */
    public void setPacotes(Set<String> pacote) {
        this.pacotes = new TreeSet<>(pacote);
    }

    /**
     * Devolve o preco.
     * @return retorna o preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * Define o preco.
     * @param preco devolve o preco.
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * Devolve o identificador do utilizador.
     * @return retorna o id do utilizador.
     */
    public String getUtilizador() {
        return utilizador;
    }
    
    /**
     * Define o id do utilizador.
     * @param utilizador id do utilizador
     */
    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve o indicador valida.
     * @return retorna o indicador valida.
     */
    public boolean isValida() {
        return valida;
    }

    /**
     * Define o indicador valida.
     * @param valida valor do indicador valida
     */
    public void setValida(boolean valida) {
        this.valida = valida;
    }

    /**
     * Devolve uma configuração copia da atual.
     * @return retorna uma copia da configuracao atual.
     */
    public Configuracao clone() {
        return new Configuracao(this);
    }

    /**
     * Devolve uma lista de listas com o formato {lista incompativeis, lista necessários}.
     * @param componente obejto Componente.
     * @return devolve o array.
     */
    public Collection<Collection<String>> valida(Componente componente) {

        Collection<Collection<String>> res = new ArrayList<>(2);
        Collection<String> incompativeis = new TreeSet<>();
        Collection<String> necessarios = new TreeSet<>();

        Set<String> todosComponentes = new TreeSet<>();
        todosComponentes.add(this.motor);
        todosComponentes.addAll(this.interiores);
        todosComponentes.addAll(this.exteriores);

        for(String id: todosComponentes)
            if (componente.getIncompativeis().contains(id))
                incompativeis.add(id);

        necessarios.addAll(componente.getNecessarios());
        necessarios.removeIf(c -> todosComponentes.contains(c));

        res.add(incompativeis);
        res.add(necessarios);

        return res;
    }

    /**
     * Define o pacote.
     * @param p pacote
     */
    public void addPacote(Pacote p){
        if(this.pacotes.contains(p.getId()) == false){
            this.pacotes.add(p.getId());
            this.desconto += p.getDesconto();
            this.preco += p.getPreco();   
        }
    }

    /**
     * Define o componente interior.
     * @param c componente interior
     */
    public void addInteriores(Componente c){
        if(this.interiores.contains(c.getId()) == false){
            this.interiores.add(c.getId());
            this.preco += c.getPreco();
        }
    }
     
    /**
     * Remove o componente interior.
     * @param c componente interior.
     */
    public void removeInteriores(Componente c) {
        if(this.interiores.contains(c.getId())){
            this.interiores.remove(c.getId());
            this.preco -= c.getPreco();
        }
    }

    /**
     * Define o componente interior.
     * @param c componente interior
     */
    public void addExteriores(Componente c) {
        if(this.exteriores.contains(c.getId()) == false){
            this.exteriores.add(c.getId());
            this.preco += c.getPreco();
        }
    }
    
    /**
     * Remove o componente exterior
     * @param c componente exterior
     */
    public void removeExteriores(Componente c) {
        if(this.exteriores.contains(c.getId())){
            this.exteriores.remove(c.getId());
            this.preco -= c.getPreco();
        }
    }
    
    /**
     * DRemove o motor.
     * @param c motor
     */
    public void removeMotor(Componente motor) {
        if (this.motor.equals("-1") == false) {
            this.motor = "-1";
            this.preco -= motor.getPreco();
        }
    }

    /**
     * Adiciona a escolha dada em argumento.
     * @param componentesAdicionar componentes a adicionar.
     * @param componentesRemover componentes a remover.
     */
    public void addEscolha(Collection<Componente> componentesAdicionar, Collection<Componente> componentesRemover){
       
        for(Componente c : componentesRemover){
            if (c.getTipo() == 1) this.removeExteriores(c);
            else if (c.getTipo() == 2) this.removeInteriores(c);
            else if (c.getTipo() == 3) this.removeMotor(c);
        }   
        
        for(Componente c : componentesAdicionar){
            if (c.getTipo() == 1)this.addExteriores(c);
            else if (c.getTipo() == 2)this.addInteriores(c);
            else if (c.getTipo() == 3) this.setMotor(c);
        }
    }
    
    @Override
    public String toString() {
        return "Configuracao{" +
                "id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", motor='" + motor + '\'' +
                ", interiores=" + interiores +
                ", exteriores=" + exteriores +
                ", pacotes=" + pacotes +
                ", preco=" + preco +
                ", desconto=" + desconto +
                ", utilizador='" + utilizador + '\'' +
                ", valida=" + valida +
                '}';
    }
    
    /**
     * Coloca na String a informação mais importante da configuração.
     * @return retorna uma String a informação mais importante da configuração.
     */
    public String prettyPrint(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Configuracao com id=").append(this.id).toString();
    }
}
