package business.comercial;

import java.util.Set;
import java.util.TreeSet;

public class Componente {

    private String id;
    private String designacao;
    private float preco;
    private int tipo;
    private Set<String> incompativeis;
    private Set<String> necessarios;
    private int stock;

    /**
     * Construtor vazio.
     */
    public Componente(){
        this.designacao = "";
        this.preco = 0f;
        this.tipo = 1;
        this.incompativeis = new TreeSet<>();
        this.necessarios = new TreeSet<>();
        this.stock = 0;
    }

    /**
     * Construtor parametrizado.
     * @param id id do Componente
     * @param designacao designacao Componente
     * @param preco preco do Componente
     * @param tipo tipo do componente
     * @param incomp incompatíveis
     * @param nec necessários
     * @param stock stock do componente
     */
    public Componente(String id, String designacao,float preco,int tipo,Set<String> incomp,Set<String> nec, int stock){
        this.id = id;
        this.designacao=designacao;
        this.preco = preco;
        this.tipo = tipo;
        setIncompativeis(incomp);
        setNecessarios(nec);
        this.stock = stock;
    }

    /**
     * Construtor cópia.
     * @param c componente a copiar.
     */
    public Componente(Componente c){
        this.id = c.getId();
        this.designacao = c.getDesignacao();
        this.preco = c.getPreco();
        this.tipo = c.getTipo();
        setIncompativeis(c.getIncompativeis());
        setNecessarios(c.getNecessarios());
        this.stock = c.getStock();
    }

    /**
     * Retorna o id do Componente.
     * @return retorna o id do Componente.
     */
    public String getId() {
        return id;
    }

    /**
     * Coloca o id do componente.
     * @param id id do componente.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retorna a designação do componente.
     * @return retorna a designação do componente.
     */
    public String getDesignacao() {
        return this.designacao;
    }

    /**
     * Retorna o preco do componente.
     * @return retorna componente.
     */
    public float getPreco() {
        return this.preco;
    }

    /**
     * Retorna o tipo do componente.
     * @return Retorna o tipo componente.
     */
    public int getTipo() {
        return this.tipo;
    }

    /**
     * Retorna os incompativeis.
     * @return retorna os incompativeis.
     */
    public Set<String> getIncompativeis() {
        Set<String> res = new TreeSet<>();
        for(String s:this.incompativeis){
            res.add(s);
        }
        return res;
    }

    /**
     * Retorna o stock do componente.
     * @return retorna o stock do componente.
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Coloca a designação do componente.
     * @param designacao designação do componente.
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Coloca o preço do componente.
     * @param preco preço do componente.
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * Coloca o tipo do componente.
     * @param tipo tipo do componente.
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna os necessários do componente.
     * @return retorna os necessários do componente.
     */
    public Set<String> getNecessarios() {
        Set<String> res = new TreeSet<>();
        for(String s:this.necessarios){
            res.add(s);
        }
        return res;
    }


    /**
     * Coloca os incompatíveis do componente.
     * @param incomp incompatíveis.
     */
    public void setIncompativeis(Set<String> incomp) {
        this.incompativeis = new TreeSet<>();
        for(String s:incomp){
            this.incompativeis.add(s);
        }
    }

    public void setNecessarios(Set<String> nec) {
        this.necessarios = new TreeSet<>();
        for(String s:nec){
            this.necessarios.add(s);
        }
    }


    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Componente)) return false;
        Componente that = (Componente) o;
        return (Float.compare(that.preco, preco) == 0
                && this.designacao.equals(that.getDesignacao())
                && (this.tipo == that.getTipo())
                && this.incompativeis.equals(that.getIncompativeis())
                && this.incompativeis.equals(that.getNecessarios()));
    }

    @Override
    public Componente clone(){
        return new Componente(this);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Componente={");
        sb.append("id=").append(id);
        sb.append(", designacao=").append(designacao);
        sb.append(", preco=").append(preco);
        sb.append(", tipo=").append(tipo);
        sb.append(", incompativeis=").append(incompativeis);
        sb.append(", necessarios=").append(necessarios);
        sb.append(", stock=").append(stock).append("}");
        return sb.toString();
    }
    
    /**
     * Coloca numa String a informação de uma forma mais intuitiva.
     * @return retorna uma String com a informação de uma forma mais intuitiva.
     */
    public String prettyPrint(){
        StringBuilder sb = new StringBuilder();
        sb.append("designacao=").append(designacao).append(" | ");
        sb.append("preco=").append(preco).append(" | ");
        sb.append("stock=").append(stock);
        
        return sb.toString();
    }   
}