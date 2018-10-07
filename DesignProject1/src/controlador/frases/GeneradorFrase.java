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
public class GeneradorFrase {
    private FraseBuilder fraseBuilder;
    
    public void setFraseBuilder(FraseBuilder fraseBuilder) {
        this.fraseBuilder = fraseBuilder;
    }
    
    public Frase getFrase() {
        return fraseBuilder.getFrase();
    }
    
    public void construirFrase(int largo, ArrayList<Character> alfabeto) {
        fraseBuilder.crearNuevaFrase();
        fraseBuilder.buildFrase(largo,alfabeto);
    }
}
