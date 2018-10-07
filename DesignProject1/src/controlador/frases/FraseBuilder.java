/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.frases;

import java.util.ArrayList;
import modelo.Frase;

/**
 *
 * @author gerald
 */
public abstract class FraseBuilder {
    protected Frase frase;

    public FraseBuilder() {
    }
    
    
    
    public Frase getFrase() {
        return frase;
    }
    
    public void crearNuevaFrase() {
        frase = new Frase();
    }
    
    public abstract void buildFrase(int largo,ArrayList<Character> alfabeto);
}
