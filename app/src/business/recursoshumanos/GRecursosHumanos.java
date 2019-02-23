/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.recursoshumanos;
import data.DAOFacade;
import business.recursoshumanos.UtilizadorNaoExisteException;
import business.recursoshumanos.Utilizador;

/**
 *
 * @author ricardopetronilho
 */
public class GRecursosHumanos {
    private DAOFacade daoFacade;
    
    public GRecursosHumanos(DAOFacade daoFacade){
        this.daoFacade = daoFacade;
    }
    
    public int autenticar(String id, String password) throws UtilizadorNaoExisteException{
        if(!this.daoFacade.getUtilizadores().containsKey(id)) throw new UtilizadorNaoExisteException(id);
        
        Utilizador utilizador = this.daoFacade.getUtilizadores().get(id);
        
        String idUtilizador = utilizador.getId();
        String passwordUtilizador  = utilizador.getPassword();
        
        if(idUtilizador.equals(id) && passwordUtilizador.equals(password)) return utilizador.getTipo();    //  correu bem e retornamos o tipo de utilizador.
        else if(idUtilizador.equals(id) && !passwordUtilizador.equals(password)) return -2;  //  password errada 
        return -1;  //  erro interno
    }
}