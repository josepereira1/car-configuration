/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.comercial;

import data.DAOFacade;

import java.util.*;

/**
 *
 * @author ricardopetronilho
 */





public class GComercial {
    
    private DAOFacade daoFacade;
    
    public GComercial(DAOFacade daoFacade) {
        this.daoFacade = daoFacade;
    }
    
    /** ------------------------Métodos do Use Case Criar Configuração Ótima ------------------------*/
    
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
     
    public  void getPropostaValida(float valorDisposto, String chaveConfiguracaoOtima) throws ConfiguracaoNaoExisteException, ModeloNaoExisteException, ComponenteNaoExisteException, PacoteNaoExisteException {

        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracaoOtima) == false)
            throw new ConfiguracaoNaoExisteException(chaveConfiguracaoOtima);

        Configuracao configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracaoOtima);
        String chaveModelo = configuracao.getModelo();

        if (this.daoFacade.getModelos().containsKey(chaveModelo) == false) throw new ModeloNaoExisteException(chaveModelo);
        Modelo modelo = this.daoFacade.getModelos().get(chaveModelo);

        // ordena de forma crescente
        Comparator<Componente> comparator = new Comparator<Componente>() {
            @Override
            public int compare(Componente o1, Componente o2) {
                if (o1.getPreco() == o2.getPreco()) return 0;
                else if (o1.getPreco() > o2.getPreco()) return 1;
                else return -1;
            }
        };

        List<Componente> exteriores = new ArrayList<>();
        List<Componente> interiores = new ArrayList<>();
        List<Componente> motorizacoes = new ArrayList<>();

        for(String id: modelo.getExteriorCompativeis()) {
            if (this.daoFacade.getComponentes().containsKey(id) == false) throw new ComponenteNaoExisteException(id);
            exteriores.add(this.daoFacade.getComponentes().get(id));
        }
        exteriores.sort(comparator);

        for(String id: modelo.getInterioresCompativeis()) {
            if (this.daoFacade.getComponentes().containsKey(id) == false) throw new ComponenteNaoExisteException(id);
            interiores.add(this.daoFacade.getComponentes().get(id));
        }
        interiores.sort(comparator);

        for(String id: modelo.getMotorizacoesCompativeis()) {
            if (this.daoFacade.getComponentes().containsKey(id) == false) throw new ComponenteNaoExisteException(id);
            motorizacoes.add(this.daoFacade.getComponentes().get(id));
        }
        motorizacoes.sort(comparator);
        
        int i = 0;
        float valorTotal = 0f;

        while(configuracao.getPreco() < valorDisposto) {
            
            if ( i > exteriores.size() && i > interiores.size() && i > motorizacoes.size()) break;

            Iterator<Collection<String>> it;
            
            if (i < motorizacoes.size()) {
                configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracaoOtima);
                Componente motor = motorizacoes.get(i);
                it = this.validaConfiguracaoAtual(motor.getId(), chaveConfiguracaoOtima).iterator();
                Collection<String> inc = it.next();
                Collection<String> nec = it.next();
                nec.add(motor.getId());
                valorTotal = 0f;
                for(String id: nec) valorTotal += this.daoFacade.getComponentes().get(id).getPreco();
                if (configuracao.getPreco() + valorTotal <= valorDisposto) this.addEscolha(nec, inc, chaveConfiguracaoOtima);           
            }
            
            if (i < exteriores.size()) {
                configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracaoOtima);
                Componente exterior = exteriores.get(i);
                it = this.validaConfiguracaoAtual(exterior.getId(), chaveConfiguracaoOtima).iterator();
                Collection<String> inc = it.next();
                Collection<String> nec = it.next();
                nec.add(exterior.getId());
                valorTotal = 0f;
                for(String id: nec) valorTotal += this.daoFacade.getComponentes().get(id).getPreco();
                if (configuracao.getPreco() + valorTotal <= valorDisposto) this.addEscolha(nec, inc, chaveConfiguracaoOtima);           
            }
            
            if (i < interiores.size()) {
                configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracaoOtima);
                Componente interior = interiores.get(i);
                it = this.validaConfiguracaoAtual(interior.getId(), chaveConfiguracaoOtima).iterator();
                Collection<String> inc = it.next();
                Collection<String> nec = it.next();
                nec.add(interior.getId());
                valorTotal = 0f;
                for(String id: nec) valorTotal += this.daoFacade.getComponentes().get(id).getPreco();
                if (configuracao.getPreco() + valorTotal <= valorDisposto) this.addEscolha(nec, inc, chaveConfiguracaoOtima);           
            }
            
           i++;
        }

        // verifica se tem pacote e adiciona caso tenha
        this.containsPacote(configuracao.getId());

        this.daoFacade.getConfiguracoes().put(configuracao.getId(), configuracao);
    }
    
   
    /** ----------------------------Métodos do Use Case Iniciar Produção ----------------------------*/
    /**
     * Devolve apenas as configurações completas, prontas a serem produzidas.
     * @return lista de configurações
     */
    public List<Configuracao> getConfiguracoesAProduzir() {
        List<Configuracao> res = new ArrayList<>();
        for(Configuracao c: this.daoFacade.getConfiguracoes().values()) {
            if (c.isValida()) {
                res.add(c);
            }
        }
        return res;
    }
    
    /** 
     * Verifica se existem todos os componentes em stock para produzir a configuração.
     * @param chaveConfiguracao identificador da configuração.
     * @return true caso todos os componentes estejam disponíveis, false caso contrário.
     * @throws ConfiguracaoNaoExisteException caso a configuração não exista
     */
    public boolean temStock(String chaveConfiguracao) throws ConfiguracaoNaoExisteException {
        
        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false)
            throw new ConfiguracaoNaoExisteException(chaveConfiguracao);
        
        Configuracao c = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);
        
        for(String chave: c.getInteriores())
            if (this.daoFacade.getComponentes().getStock(chave) <= 0) 
                return false;
        
        for(String chave: c.getExteriores())
            if (this.daoFacade.getComponentes().getStock(chave) <= 0) 
                return false;
        
        for(String pacote: c.getPacotes())
            for(String chave: this.daoFacade.getPacotes().get(pacote).getComponentes())
                if (this.daoFacade.getComponentes().getStock(chave) <= 0) 
                    return false;
        
        return true;
    }





    /** ---------------------------- Métodos do Use Case Criar Configuração Individualizada ----------------------------*/
    /**
     * Cria uma configuração vazia e adiciona a mesma ao DAO.
     */
    public String criarConfiguracao(String utilizadorId) {
        Configuracao c = new Configuracao();
        int id = this.daoFacade.getConfiguracoes().getCurrentIdConfiguracoes();
        c.setId(Integer.toString(id));
        c.setUtilizador(utilizadorId);
        this.daoFacade.getConfiguracoes().put(c.getId(), c);
        return c.getId();
    }

    /**
     * Define o motor de uma configuração.
     * @param chaveMotorizacao identificador do motor.
     * @param chaveConfiguracao identificador da configuração.
     * @throws ConfiguracaoNaoExisteException
     */
    public void setMotorizacao(String chaveMotorizacao, String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ComponenteNaoExisteException {
        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false) throw new ConfiguracaoNaoExisteException(chaveConfiguracao);
        Configuracao c = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);
        if (this.daoFacade.getComponentes().containsKey(chaveMotorizacao) == false) throw new ComponenteNaoExisteException(); 
        Componente motor = this.daoFacade.getComponentes().get(chaveMotorizacao);
        c.setMotor(motor);
        this.daoFacade.getConfiguracoes().put(c.getId(), c);
    }

    
    
    /**
     * Devolve uma Collection de pacotes existentes numa configuração.
     * @param chaveConfiguracao identificador da configuração.
     * @return collection de pacotes
     * @throws ConfiguracaoNaoExisteException
     * @throws business.comercial.PacoteNaoExisteException
     */
    public Collection<Pacote> containsPacote(String chaveConfiguracao) throws ConfiguracaoNaoExisteException, PacoteNaoExisteException {

        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false) throw new ConfiguracaoNaoExisteException(chaveConfiguracao);

        Configuracao c = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);
        
        Collection<Pacote> pacotes = new ArrayList<>();

        Set<String> todosComponentes = new TreeSet<>();
        //todosComponentes.add(c.getMotor());
        todosComponentes.addAll(c.getInteriores());
        todosComponentes.addAll(c.getExteriores());

        for(Pacote p: this.daoFacade.getPacotes().values()) {
            if (todosComponentes.containsAll(p.getComponentes())) {
                c.addPacote(p);
                pacotes.add(p);
            }
        }
        
        // caso tenha adiciona pacote, atualiza a configuracao (preco e id do pacote)
        if (pacotes.isEmpty() == false) this.daoFacade.getConfiguracoes().put(c.getId(), c);

        return pacotes;
    }

    /** ---------------------------- */

    /**
     * Adiciona o pacote a configuracao
     * @return
     */
    public void addPacote(String chavePacote,String chaveConfiguracao) throws PacoteNaoExisteException, ConfiguracaoNaoExisteException{
        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false) throw new ConfiguracaoNaoExisteException(chaveConfiguracao);
        Configuracao configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);
        if (this.daoFacade.getPacotes().containsKey(chavePacote) == false) throw new PacoteNaoExisteException(chavePacote);
        Pacote p = this.daoFacade.getPacotes().get(chavePacote);
        configuracao.addPacote(p);
        this.daoFacade.getConfiguracoes().put(configuracao.getId(), configuracao);
    }

    /**
     * Devolve a lista de motorizacoes compativeis com o modelo.
     * @param chaveConfiguracao 
     * @return lista de motores(componentes)
     */
    public Collection<Componente> getMotorizacoes(String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ModeloNaoExisteException, ComponenteNaoExisteException{
        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false) throw new ConfiguracaoNaoExisteException(chaveConfiguracao);
        Configuracao configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);
        String chaveModelo = configuracao.getModelo();
        if (this.daoFacade.getModelos().containsKey(chaveModelo) == false) throw new ModeloNaoExisteException(chaveModelo);
        Modelo modelo = this.daoFacade.getModelos().get(chaveModelo);
        Set<String> motorizacoes = modelo.getMotorizacoesCompativeis();
        Collection<Componente> listMotorizacoes = new ArrayList<>();
        for(String s: motorizacoes){
            if (this.daoFacade.getComponentes().containsKey(s) == false) throw new ComponenteNaoExisteException(s);
            Componente motor = this.daoFacade.getComponentes().get(s);
            listMotorizacoes.add(motor);
        }
        return listMotorizacoes;
    }

    
    
    /**
     * Devolve uma Collection com os componentes do tipo interior compatíveis com o modelo escolhido desta configuração.
     * @param chaveConfiguracao chave da configuração.
     * @return retorna uma Collection com os componentes do tipo interior compatíveis com o modelo escolhido desta configuração.
     */
    
    public Collection<Componente> getInteriores(String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ModeloNaoExisteException, ComponenteNaoExisteException{
        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false) throw new ConfiguracaoNaoExisteException(chaveConfiguracao);
        Configuracao configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);
        String chaveModelo = configuracao.getModelo();
        if (this.daoFacade.getModelos().containsKey(chaveModelo) == false) throw new ModeloNaoExisteException(chaveModelo);
        Modelo modelo = this.daoFacade.getModelos().get(chaveModelo);
        Set<String> interiores = modelo.getInterioresCompativeis();
        Collection<Componente> listaInteriores = new ArrayList<>();
        for(String s: interiores){
            if (this.daoFacade.getComponentes().containsKey(s) == false) throw new ComponenteNaoExisteException(s);
            Componente interior = this.daoFacade.getComponentes().get(s);
            listaInteriores.add(interior);
        }
        return listaInteriores;
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
        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false) throw new ConfiguracaoNaoExisteException(chaveConfiguracao);
        Configuracao c = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);
        if (this.daoFacade.getModelos().containsKey(chaveModelo) == false) throw new ModeloNaoExisteException(chaveModelo);
        Modelo modelo = this.daoFacade.getModelos().get(chaveModelo);
        c.setModelo(modelo);
        this.daoFacade.getConfiguracoes().put(c.getId(), c);
    }

    /**
     * Valida a configuração, retornando ids de componentes incompatíveis ou necessários.
     * @param chaveComponente identificador do modelo.
     * @param chaveConfiguracao identificador da configuração.
     * @throws business.comercial.ConfiguracaoNaoExisteException
     * @throws business.comercial.ComponenteNaoExisteException
     */
    public  Collection<Collection<String>> validaConfiguracaoAtual(String chaveComponente, String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ComponenteNaoExisteException {
        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false) throw new ConfiguracaoNaoExisteException(chaveConfiguracao);
        Configuracao c = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);
        if (this.daoFacade.getComponentes().containsKey(chaveComponente) == false) throw new ComponenteNaoExisteException(chaveComponente);
        Componente comp = this.daoFacade.getComponentes().get(chaveComponente);
        
        Collection<Collection<String>> res = c.valida(comp);
                
        Iterator<Collection<String>> it = res.iterator();
        Collection<String> incompativeis = it.next();
        Collection<String> necessarios = it.next();
        
        //itero a copia 
        for(String chave: new ArrayList<>(necessarios)) {
            if (this.daoFacade.getComponentes().containsKey(chave) == false) throw new ComponenteNaoExisteException(chave);
            Componente comp2 = this.daoFacade.getComponentes().get(chave);
            Collection<Collection<String>> tmp = c.valida(comp2);
            Iterator<Collection<String>> it2 = tmp.iterator();
            incompativeis.addAll(it2.next());
            necessarios.addAll(it2.next());
        }

        return res;
    }

    /**
     * Apresenta lista de pacotes compatíveis para o modelo escolhido.
     * @param chaveConfiguracao identificador da configuração.
     * @throws business.comercial.ConfiguracaoNaoExisteException
     * @throws business.comercial.ModeloNaoExisteException
     * @throws business.comercial.PacoteNaoExisteException
     */
    public Collection<Pacote> getPacotes(String chaveConfiguracao) throws ConfiguracaoNaoExisteException, ModeloNaoExisteException, PacoteNaoExisteException {

        Collection<Pacote> res = new HashSet<Pacote>();

        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false)
            throw new ConfiguracaoNaoExisteException(chaveConfiguracao);

        Configuracao c = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);

        String chaveModelo = c.getModelo();

        if (this.daoFacade.getModelos().containsKey(chaveModelo) == false)
            throw new ModeloNaoExisteException(chaveModelo);

        Modelo m = this.daoFacade.getModelos().get(chaveModelo);

        Set<String> pacotes = new TreeSet<String>();

        for(String chavePacote:  m.getPacotesCompativeis()) {

            if (this.daoFacade.getPacotes().containsKey(chavePacote) == false)
                throw new PacoteNaoExisteException(chavePacote);

            Pacote p = this.daoFacade.getPacotes().get(chavePacote);

            res.add(p);
        }

        return res;
    }

    /**
     * Valida a configuração, ficando pronta para ser submetida na fábrica.
     * @param chaveConfiguracao identificador da configuração.
     * @throws business.comercial.ConfiguracaoNaoExisteException
     */
    public void submeterFabrica(String chaveConfiguracao)throws ConfiguracaoNaoExisteException{

        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false)
            throw new ConfiguracaoNaoExisteException(chaveConfiguracao);

        Configuracao c = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);

        c.setValida(true);

        this.daoFacade.getConfiguracoes().put(c.getId(), c);
    }

    /**
     * Adiciona um componente a uma configuração.
     * 1 se é exterior, 2 se é interior e 3 se é motor
     * @param chaveConfiguracao identificador da configuração.
     * @param chaveComponente id do componente a adicionar
     * @throws business.comercial.ConfiguracaoNaoExisteException
     * @throws business.comercial.ComponenteNaoExisteException
     */
    public void  addComponente(String chaveComponente, String chaveConfiguracao)  throws ConfiguracaoNaoExisteException, ComponenteNaoExisteException{

        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false)
            throw new ConfiguracaoNaoExisteException(chaveConfiguracao);

        Configuracao c = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);

        if (this.daoFacade.getComponentes().containsKey(chaveComponente) == false)
            throw new ComponenteNaoExisteException(chaveComponente);

        Componente comp = this.daoFacade.getComponentes().get(chaveComponente);

        int tipo = comp.getTipo();

        if(tipo == 2) c.addInteriores(comp);     //adicionar aos exteriores anteriormente existentes
        else if(tipo == 1) c.addExteriores(comp);    //adicionar aos interiores anteriormente existentes

        this.daoFacade.getConfiguracoes().put(c.getId(), c);
    }


    /** ---------------------------- */

    /**
     * Devolve o catálogo (modelos).
     * @return retorna o catálogo.
     */
    public Collection<Modelo> getCatalogo(){
        return this.daoFacade.getModelos().values();
    }

    /**
     * Devolve uma Collection com os componentes do tipo exterior compatíveis com o modelo escolhido desta configuração.
     * @param chaveConfiguracao chave da configuração.
     * @return retorna uma Collection com os componentes do tipo exterior compatíveis com o modelo escolhido desta configuração.
     */
    public Collection<Componente> getExterior(String chaveConfiguracao) throws ModeloNaoExisteException, ComponenteNaoExisteException, ConfiguracaoNaoExisteException{
        
        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false)
            throw new ConfiguracaoNaoExisteException(chaveConfiguracao);
        
        Configuracao configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);

        String chaveModelo = configuracao.getModelo();
        
        if (this.daoFacade.getModelos().containsKey(chaveModelo) == false)
            throw new ModeloNaoExisteException(chaveModelo);
        
        Modelo modelo = this.daoFacade.getModelos().get(chaveModelo);
        
        Set<String> idExteriores = modelo.getExteriorCompativeis();

        Collection<Componente> col = new HashSet<Componente>();
         

        for(String chave : idExteriores){
            if (this.daoFacade.getComponentes().containsKey(chave) == false) throw new ComponenteNaoExisteException(chave);
           Componente p = this.daoFacade.getComponentes().get(chave);
           col.add(p);
        }
        return col;
    }

    /**
     * Adiciona a escolha dada em argumento.
     * @param listaComponentesAdicionar lista de componentes a adicionar.
     * @param listaComponentesRemover lista de componentes a remover.
     * @param chaveConfiguracao chave da configuração.
     */
    public void addEscolha(Collection<String> listaComponentesAdicionar, Collection<String> listaComponentesRemover, String chaveConfiguracao) throws ComponenteNaoExisteException, ConfiguracaoNaoExisteException {
        
        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false) throw new ConfiguracaoNaoExisteException(chaveConfiguracao);
        Configuracao configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);

        Collection<Componente> componentesAdicionar = new ArrayList<>();
        Collection<Componente> componentesRemover = new ArrayList<>();       

        for(String chave : listaComponentesAdicionar) {
            if (this.daoFacade.getComponentes().containsKey(chave) == false) throw new ComponenteNaoExisteException(chave);
            componentesAdicionar.add(this.daoFacade.getComponentes().get(chave));
        }
        
        for(String chave : listaComponentesRemover) {
            if (this.daoFacade.getComponentes().containsKey(chave) == false) throw new ComponenteNaoExisteException(chave);
            componentesRemover.add(this.daoFacade.getComponentes().get(chave));
        }

        configuracao.addEscolha(componentesAdicionar,componentesRemover);
        
        this.daoFacade.getConfiguracoes().put(configuracao.getId(), configuracao);
    }
    
    public Configuracao getConfiguracao(String chaveConfiguracao) {
        return this.daoFacade.getConfiguracoes().get(chaveConfiguracao);
    }
   
    /** ---------------------------- Métodos Gerais -------------------------------------------------------------------*/

    /**
     * Remove a configuração do sistema.
     * @param chaveConfiguracao identificador da configuração.
     */
    public void removeConfiguracao(String chaveConfiguracao) throws ConfiguracaoNaoExisteException {

        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false)
            throw new ConfiguracaoNaoExisteException(chaveConfiguracao);

        this.daoFacade.getConfiguracoes().remove(chaveConfiguracao);
    }
    
    
    
     /**
     * Devolve todos os componentes de tipo exterior da configuração em questão.
     * @param chaveConfiguracao identificador da configuração.
     * @return collection de componentes
     * @throws business.comercial.ConfiguracaoNaoExisteException
     */  
      public Collection<Componente> getExteriorConfiguracao(String chaveConfiguracao) throws ConfiguracaoNaoExisteException{
         
        if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false)
         throw new ConfiguracaoNaoExisteException(chaveConfiguracao);  
        
        Configuracao configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);

       
        
        Set<String> idExteriores = configuracao.getExteriores();

        Collection<Componente> col = new HashSet<Componente>();
         

        for(String chave : idExteriores){
           Componente p = this.daoFacade.getComponentes().get(chave);
           col.add(p);
        }
        return col;
    }
    
    
     /**
     * Devolve todos os componentes de tipo interior da configuração em questão.
     * @param chaveConfiguracao identificador da configuração.
     * @return collection de componentes
     * @throws business.comercial.ConfiguracaoNaoExisteException
     */  
     public Collection<Componente> getInteriorConfiguracao(String chaveConfiguracao) throws ConfiguracaoNaoExisteException{
         if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false)
         throw new ConfiguracaoNaoExisteException(chaveConfiguracao);  
        
         
        Configuracao configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);

       
        
        Set<String> idInteriores = configuracao.getInteriores();

        Collection<Componente> col = new HashSet<Componente>();
         

        for(String chave : idInteriores){
           Componente p = this.daoFacade.getComponentes().get(chave);
           col.add(p);
        }
        return col;
    }
 
     
 /**
     * Devolve todos os pacotes da configuração em questão.
     * @param chaveConfiguracao identificador da configuração.
     * @return collection de pacotes
     * @throws business.comercial.ConfiguracaoNaoExisteException
     */    
  public Collection<Pacote> getPacotesConfiguracao(String chaveConfiguracao) throws ConfiguracaoNaoExisteException{
      
      if (this.daoFacade.getConfiguracoes().containsKey(chaveConfiguracao) == false)
         throw new ConfiguracaoNaoExisteException(chaveConfiguracao);  
        
        Configuracao configuracao = this.daoFacade.getConfiguracoes().get(chaveConfiguracao);

       
        
        Set<String> idPacotes = configuracao.getPacotes();

        Collection<Pacote> col = new HashSet<Pacote>();
         

        for(String chave : idPacotes){
           Pacote p = this.daoFacade.getPacotes().get(chave);
           col.add(p);
        }
        return col;
    }
  
  /**
   * Adiciona a quantidade dada como parametro ao stock atual do componente.
   * @param idComponente id do componente
   * @param quantidade quantidade a adicioanar ao stock
   * @throws ComponenteNaoExisteException componente nao existe 
   */
    public void adicionarSotck(String idComponente, int quantidade) throws ComponenteNaoExisteException{
        if(this.daoFacade.getComponentes().containsKey(idComponente)){
          int quantidadeTotal = this.daoFacade.getComponentes().get(idComponente).getStock() + quantidade;
          //  este setStock vai atualizar o valor diretamente na base de dados.
          this.daoFacade.getComponentes().adicionaStock(idComponente, quantidadeTotal);
        }else{
            throw new ComponenteNaoExisteException(idComponente);
        }
    }
}
