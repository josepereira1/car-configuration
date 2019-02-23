/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.comercial.ComponenteNaoExisteException;

/**
 *
 * @author ricardopetronilho
 */
public class DAOFacade {
    
    private ConfiguracaoDAO configuracoes;  
    private ComponenteDAO componentes;
    private ModeloDAO modelos;
    private UtilizadorDAO utilizadores;
    private PacoteDAO pacotes;

    public DAOFacade() {
        this.configuracoes = new ConfiguracaoDAO();
        this.componentes = new ComponenteDAO();
        this.modelos = new ModeloDAO();
        this.utilizadores = new UtilizadorDAO();
        this.pacotes = new PacoteDAO();
    }

    public ConfiguracaoDAO getConfiguracoes() {
        return configuracoes;
    }
    
    public ComponenteDAO getComponentes() {
        return componentes;
    }
    
    public ModeloDAO getModelos() {
        return modelos;
    }

    public UtilizadorDAO getUtilizadores() {
        return utilizadores;
    }

    public PacoteDAO getPacotes() {
        return pacotes;
    }
    
    public void adicionarStock(String idComponente, int quantidade) throws ComponenteNaoExisteException{
        this.componentes.adicionaStock(idComponente, quantidade);
    }
}
