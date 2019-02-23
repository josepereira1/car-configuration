package business.comercial;


import java.util.Set;
import java.util.TreeSet;

public class Modelo {

    private String id;
    private String designacao;
    private float preco;
    private String pinturaPadrao;
    private String jantesPadrao;
    private Set<String> motorizacoesCompativeis;
    private Set<String> interioresCompativeis;
    private Set<String> exteriorCompativeis;
    private Set<String> pacotesCompativeis;

    /**
     * Construtor vazio.
     */
    public Modelo(){
        id = "";
        designacao = "";
        preco = 0;
        pinturaPadrao = "";
        jantesPadrao = "";
        motorizacoesCompativeis = new TreeSet<String>();
        interioresCompativeis = new TreeSet<String>();
        exteriorCompativeis = new TreeSet<String>();
        pacotesCompativeis = new TreeSet<String>();
    }

    /**
     * Construtor parametrizado.
     * @param id id do modelo.
     * @param designacao designacao do modelo.
     * @param preco preço do modelo.
     * @param pinturaPadrao pintura padrão do modelo.
     * @param jantesPadrao jantes padrão do modelo.
     */
    public Modelo(String id, String designacao, float preco, String pinturaPadrao, String jantesPadrao, Set<String> motorizacoesCompativeis, Set<String> interioresCompativeis, Set<String> exteriorCompativeis, Set<String> pacotesCompativeis) {
        this.id = id;
        this.designacao = designacao;
        this.preco = preco;
        this.pinturaPadrao = pinturaPadrao;
        this.jantesPadrao = jantesPadrao;
        this.setMotorizacoesCompativeis(motorizacoesCompativeis);
        this.setInterioresCompativeis(interioresCompativeis);
        this.setExteriorCompativeis(exteriorCompativeis);
        this.setPacotesCompativeis(pacotesCompativeis);
    }

    /**
     * Construtor cópia.
     * @param modelo modelo a copiar.
     */
    public Modelo(Modelo modelo){
        this.id = modelo.getId();
        this.designacao = modelo.getDesignacao();
        this.preco = modelo.getPreco();
        this.pinturaPadrao = modelo.getPinturaPadrao();
        this.jantesPadrao = modelo.getJantesPadrao();
        this.setMotorizacoesCompativeis(modelo.getMotorizacoesCompativeis());
        this.setInterioresCompativeis(modelo.getInterioresCompativeis());
        this.setExteriorCompativeis(modelo.getExteriorCompativeis());
        this.setPacotesCompativeis(modelo.getPacotesCompativeis());
    }

    /**
     * Devolve o id do modelo.
     * @return retorna o id do modelo.
     */
    public String getId() {
        return id;
    }

    /**
     * Coloca o id do modelo.
     * @param id id do modelo.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Devolve a designacao.
     * @return retorna a designacao.
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Coloca a designacao do modelo.
     * @param designacao designacao do modelo.
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Devolve o preco do modelo.
     * @return retorna o preco do modelo.
     */
    public float getPreco() {
        return preco;
    }

    /**
     * Coloca o preço do modelo.
     * @param preco preço do modelo
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * Devolve o id da pintura padrão.
     * @return retorna o id da pintura padrão.
     */
    public String getPinturaPadrao() {
        return pinturaPadrao;
    }

    /**
     * Coloca o id da pintura padrão do modelo.
     * @param pinturaPadrao id da pintura padrão do modelo.
     */
    public void setPinturaPadrao(String pinturaPadrao) {
        this.pinturaPadrao = pinturaPadrao;
    }

    /**
     * Devolve o id das jantes padrão.
     * @return retorna o id das jantes padrão.
     */
    public String getJantesPadrao() {
        return jantesPadrao;
    }

    /**
     * Coloca as jantes padrão.
     * @param jantesPadrao id das jantes padrão.
     */
    public void setJantesPadrao(String jantesPadrao) {
        this.jantesPadrao = jantesPadrao;
    }

    /**
     * Retorna uma cópia deste objeto.
     * @return retorna uma cópia deste objeto.
     */
    public Modelo clone(){
        return new Modelo();
    }

    /**
     * Devolve os ids das motorizações compatíveis com este modelo.
     * @return retorna os ids das motorizações compatíveis com este modelo.
     */
    public Set<String> getMotorizacoesCompativeis(){
        return new TreeSet<String>(this.motorizacoesCompativeis);
    }

    /**
     * Colocar os ids das motorizações compatíveis com este modelo.
     * @param motorizacoesCompativeis ids das motorizações compatíveis.
     */
    public void setMotorizacoesCompativeis(Set<String> motorizacoesCompativeis){
        this.motorizacoesCompativeis = new TreeSet<String>(motorizacoesCompativeis);
    }

    /**
     * Devolver os ids dos interiores compatíveis com este modelo.
     * @return retorna os ids dos interiores compatíveis com este modelo.
     */
    public Set<String> getInterioresCompativeis(){
        return new TreeSet<String>(this.interioresCompativeis);
    }

    /**
     * Coloca os ids dos interiores compatíveis com este modelo.
     * @param interioresCompativeis ids dos interiores compatíveis com este modelo
     */
    public void setInterioresCompativeis(Set<String> interioresCompativeis){
        this.interioresCompativeis = new TreeSet<String>(interioresCompativeis);
    }

    /**
     * Devolve os ids dos exteriores compatíveis com este modelo.
     * @return retorna os ids dos exteriores compatíveis com este modelo
     */
    public Set<String> getExteriorCompativeis(){
        return new TreeSet<String>(this.exteriorCompativeis);
    }

    /**
     * Coloca os ids dos exteriores compatíveis com este modelo.
     * @param exteriorCompativeis ids dos exteriores compatíveis com este modelo.
     */
    public void setExteriorCompativeis(Set<String> exteriorCompativeis){
        this.exteriorCompativeis = new TreeSet<String>(exteriorCompativeis);
    }

    /**
     * Devolve os ids dos pacotes compatíveis com este modelo.
     * @return retorna os ids dos pacotes compatíveis com este modelo.
     */
    public Set<String> getPacotesCompativeis(){
        return new TreeSet<String>(this.pacotesCompativeis);
    }

    /**
     * Coloca os ids dos pacotes compatíveis com este modelo.
     * @param pacotesCompativeis ids dos pacotes compatíveis com este modelo.
     */
    public void setPacotesCompativeis(Set<String> pacotesCompativeis){
        this.pacotesCompativeis = new TreeSet<String>(pacotesCompativeis);
    }

    /**
     * Testa a igualdade deste objeto com o objeto que recebe como parâmetro.
     * @param o objeto a testar
     * @return retorna o teste de igualdade entre este objeto e o objeto recebido como parâmetro.
     */
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null || this.getClass() != o.getClass())return false;

        Modelo modelo = (Modelo) o;
        return id.equals(modelo.getId()) && designacao.equals(modelo.getDesignacao())
                && preco == modelo.getPreco()
                && pinturaPadrao.equals(modelo.getPinturaPadrao())
                && jantesPadrao.equals(modelo.getJantesPadrao());
    }

    /**
     * Coloca numa String toda a informação deste objeto.
     * @return retorna uma String com toda a informação deste objeto.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Modelo={");
        sb.append("id=").append(id);
        sb.append(";designacao=").append(designacao);
        sb.append(";preco=").append(preco);
        sb.append(";pinturaPadrao=").append(pinturaPadrao);
        sb.append(";jantesPadrao=").append(jantesPadrao);
        sb.append(";motorizacoesCompativeis=").append(motorizacoesCompativeis);
        sb.append(";interioresCompativeis=").append(interioresCompativeis);
        sb.append(";exteriorCompativeis=").append(exteriorCompativeis);
        sb.append(";pacotesCompativeis=").append(pacotesCompativeis).append("};");


        return sb.toString();
    }
    
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("designacao=").append(designacao).append(" | ");
        sb.append("preco=").append(preco);
        return sb.toString();
    }
}
