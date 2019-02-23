/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.comercial;

/**
 *
 * @author ricardopetronilho
 */
public class ConfiguracaoNaoExisteException extends Exception {

    public ConfiguracaoNaoExisteException() {
    }

    public ConfiguracaoNaoExisteException(String message) {
        super(message);
    }    
}
