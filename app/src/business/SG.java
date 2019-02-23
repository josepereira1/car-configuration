/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.comercial.*;
import business.recursoshumanos.UtilizadorNaoExisteException;
import data.DAOFacade;
import business.recursoshumanos.GRecursosHumanos;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author ricardopetronilho
 */
public class SG {
    
    private GComercial gc;
    private GRecursosHumanos grh;
    private DAOFacade daoFacade;
    
    public SG() {
        this.daoFacade = new DAOFacade();
        this.gc = new GComercial(daoFacade);
        this.grh = new GRecursosHumanos(daoFacade);
    }
    
    public DAOFacade getDAOFacade() {
        return this.daoFacade;
    }
    
    
    /** 
     * Devolve uma proposta de configuração face ao modelo e preço limite escolhido.
     * @param valorDisposto
     * @param chaveConfiguracaoOtima identificador da configuração.
     * @return proposta de configuração
     * @throws ConfiguracaoNaoExisteException caso a configuração não exista
     * @throws business.comercial.ModeloNaoExisteException
     * @throws business.comercial.ComponenteNaoExisteException
     * @throws business.comercial.PacoteNaoExisteException
     */    
   public void getPropostaValida(float valorDisposto, String chaveConfiguracaoOtima) throws ConfiguracaoNaoExisteException, ModeloNaoExisteException, ComponenteNaoExisteException, PacoteNaoExisteException {
        this.gc.getPropostaValida(valorDisposto, chaveConfiguracaoOtima);
   }
    

    /** ---------------------------- Métodos do Use Case Iniciar Produção ----------------------------------------------*/
    
    /**
     * Devolve apenas as configurações completas, prontas a serem produzidas.
     * @return lista de configurações
     */
    public List<Configuracao> getConfiguracoesAProduzir() {
        return this.gc.getConfiguracoesAProduzir();
    }
    
    
    /** 
     * Verifica se existem todos os componentes em stock para produzir a configuração.
     * @param chaveConfiguracao identificador da configuração.
     * @return true caso todos os componentes estejam disponíveis, false caso contrário.
     * @throws ConfiguracaoNaoExisteException caso a configuração não exista
     */
    public boolean temStock(String chaveConfiguracao) throws ConfiguracaoNaoExisteException {
        return this.gc.temStock(chaveConfiguracao);
    }
    
    /** ---------------------------- Métodos do Use Case Criar Configuração Individualizada ----------------------------*/
    
     /**
     * Cria uma configuração vazia e adiciona a mesma ao DAO.
     */
    public String criarConfiguracao(String utilizadorId){
        return this.gc.criarConfiguracao(utilizadorId);
    }

    
      /**
     * Define o motor de uma configuração.
     * @param chaveMotorizacao identificador do motor.
     * @param chaveConfiguracao identificador da configuração.
     * @throws ConfiguracaoNaoExisteException
     */
    public void setMotorizacao(String chaveMotorizacao, String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ComponenteNaoExisteException {
        this.gc.setMotorizacao(chaveMotorizacao, chaveConfiguracao);
    }

    
    
     /**
     * Devolve uma Collection de pacotes existentes numa configuração.
     * @param chaveConfiguracao identificador da configuração.
     * @return collection de pacotes
     * @throws ConfiguracaoNaoExisteException
     * @throws business.comercial.PacoteNaoExisteException
     */
    public Collection<Pacote> containsPacote(String chaveConfiguracao) throws ConfiguracaoNaoExisteException, PacoteNaoExisteException {
        return this.gc.containsPacote(chaveConfiguracao);
    }

    /** ---------------------------- */
    
    
    /**
     * Adiciona o pacote a configuracao
     * @return
     */
    public void addPacote(String chavePacote,String chaveConfiguracao) throws PacoteNaoExisteException, ConfiguracaoNaoExisteException {
        this.gc.addPacote(chavePacote, chaveConfiguracao);
    }

    /**
     * Devolve a lista de motorizacoes compativeis com o modelo.
     * @param chaveConfiguracao 
     * @return lista de motores(componentes)
     */
    public Collection<Componente> getMotorizacoes(String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ModeloNaoExisteException, ComponenteNaoExisteException  {
        return this.gc.getMotorizacoes(chaveConfiguracao);
    }
    
    
    /**
     * Devolve uma Collection com os componentes do tipo interior compatíveis com o modelo escolhido desta configuração.
     * @param chaveConfiguracao chave da configuração.
     * @return retorna uma Collection com os componentes do tipo interior compatíveis com o modelo escolhido desta configuração.
     */
    public Collection<Componente> getInteriores(String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ModeloNaoExisteException, ComponenteNaoExisteException {
        return this.gc.getInteriores(chaveConfiguracao);
    }

    /** ---------------------------- */


    /**
     * Adiciona um modelo à configuração.
     * @param chaveModelo identificador do modelo.
     * @param chaveConfiguracao identificador da configuração.
     * @throws business.comercial.ConfiguracaoNaoExisteException
     * @throws business.comercial.ModeloNaoExisteException
     */
    public void setModelo(String chaveModelo, String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ModeloNaoExisteException {
        this.gc.setModelo(chaveModelo,chaveConfiguracao);
    }

    /**
     * Valida a configuração, retornando ids de componentes incompatíveis ou necessários.
     * @param chaveComponente identificador do modelo.
     * @param chaveConfiguracao identificador da configuração.
     * @throws business.comercial.ConfiguracaoNaoExisteException
     * @throws business.comercial.ComponenteNaoExisteException
     */
    public  Collection< Collection<String>> validaConfiguracaoAtual(String chaveComponente, String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ComponenteNaoExisteException {
        return this.gc.validaConfiguracaoAtual(chaveComponente, chaveConfiguracao);
    }

    /**
     * Apresenta lista de pacotes compatíveis para o modelo escolhido.
     * @param chaveConfiguracao identificador da configuração.
     * @throws business.comercial.ConfiguracaoNaoExisteException
     * @throws business.comercial.ModeloNaoExisteException
     * @throws business.comercial.PacoteNaoExisteException
     */
    public Collection<Pacote> getPacotes(String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ModeloNaoExisteException, PacoteNaoExisteException {
        return this.gc.getPacotes(chaveConfiguracao);
    }

    /**
     * Valida a configuração, ficando pronta para ser submetida na fábrica.
     * @param chaveConfiguracao identificador da configuração.
     * @throws business.comercial.ConfiguracaoNaoExisteException
     */
    public void submeterFabrica(String chaveConfiguracao)throws ConfiguracaoNaoExisteException{
        this.gc.submeterFabrica(chaveConfiguracao);
    }

    /**
     * Adiciona um componente a uma configuração.
     * 1 se é exterior, 2 se é interior e 3 se é motor
     * @param chaveConfiguracao identificador da configuração.
     * @param chaveComponente id do componente a adicionar
     * @throws business.comercial.ConfiguracaoNaoExisteException
     * @throws business.comercial.ComponenteNaoExisteException
     */
    public void  addComponente(String chaveComponente, String chaveConfiguracao)  throws ConfiguracaoNaoExisteException, ComponenteNaoExisteException {
        this.gc.addComponente(chaveComponente, chaveConfiguracao);
    }

    /** ---------------------------- */

    /**
     * Devolve o catálogo (modelos).
     * @return retorna o catálogo.
     */
    public Collection<Modelo> getCatalogo(){
        return gc.getCatalogo();
    }

    /**
     * Devolve uma Collection com os componentes do tipo exterior compatíveis com o modelo escolhido desta configuração.
     * @param chaveConfiguracao chave da configuração.
     * @return retorna uma Collection com os componentes do tipo exterior compatíveis com o modelo escolhido desta configuração.
     */
    public Collection<Componente> getExterior(String chaveConfiguracao) throws ModeloNaoExisteException, ComponenteNaoExisteException, ConfiguracaoNaoExisteException{
        return this.gc.getExterior(chaveConfiguracao);
    }


    /**
     * Adiciona a escolha dada em argumento.
     * @param listaComponentesAdicionar
     * @param listaComponentesRemover
     * @param chaveConfiguracao
     */
    public void addEscolha(Collection<String> listaComponentesAdicionar, Collection<String> listaComponentesRemover, String chaveConfiguracao) throws ComponenteNaoExisteException, ConfiguracaoNaoExisteException{
        this.gc.addEscolha(listaComponentesAdicionar,listaComponentesRemover,chaveConfiguracao);
    }
    
    public Configuracao getConfiguracao(String chaveConfiguracao) {
        return this.gc.getConfiguracao(chaveConfiguracao);
    }
    
    /** ---------------------------- Métodos Gerais -------------------------------------------------------------------*/
    
     /**
     * Remove a configuração do sistema.
     * @param chaveConfiguracao identificador da configuração.
     */
    public void removeConfiguracao(String chaveConfiguracao) throws ConfiguracaoNaoExisteException {
        this.gc.removeConfiguracao(chaveConfiguracao);
    }
    
    
    
    public int autenticar(String id, String password) throws UtilizadorNaoExisteException{
        return this.grh.autenticar(id, password);
    }
    
    
    /**
     * Devolve todos os componentes de tipo exterior da configuração em questão.
     * @param chaveConfiguracao identificador da configuração.
     * @return collection de componentes
     * @throws business.comercial.ConfiguracaoNaoExisteException
     */  
    public Collection<Componente> getExteriorConfiguracao(String chaveConfiguracao) throws ConfiguracaoNaoExisteException{
         return this.gc.getExteriorConfiguracao(chaveConfiguracao);
     }
    
     /**
     * Devolve todos os componentes de tipo interior da configuração em questão.
     * @param chaveConfiguracao identificador da configuração.
     * @return collection de componentes
     * @throws business.comercial.ConfiguracaoNaoExisteException
     */ 
     public Collection<Componente> getInteriorConfiguracao(String chaveConfiguracao) throws ConfiguracaoNaoExisteException{
         return this.gc.getInteriorConfiguracao(chaveConfiguracao);
     }
     
    /**
     * Devolve todos os pacotes da configuração em questão.
     * @param chaveConfiguracao identificador da configuração.
     * @return collection de pacotes
     * @throws business.comercial.ConfiguracaoNaoExisteException
     */
     public Collection<Pacote> getPacotesConfiguracao(String chaveConfiguracao) throws ConfiguracaoNaoExisteException{
         return this.gc.getPacotesConfiguracao(chaveConfiguracao);
     }
    
    
    /**
   * Adiciona a quantidade dada como parametro ao stock atual do componente.
   * @param idComponente id do componente
   * @param quantidade quantidade a adicioanar ao stock
   * @throws ComponenteNaoExisteException componente nao existe 
   */ 
     public void adicionaStock(String idComponente, int quantidade) throws ComponenteNaoExisteException{
         this.gc.adicionarSotck(idComponente, quantidade);
     }
    
}
