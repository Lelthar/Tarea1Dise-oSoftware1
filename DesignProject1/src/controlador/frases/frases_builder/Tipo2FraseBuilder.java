/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.frases.frases_builder;

import controlador.frases.FraseBuilder;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class Tipo2FraseBuilder extends FraseBuilder {
    
    public void buildFrase(int largo,ArrayList<Character> alfabeto){
        ArrayList<Character> copiaAlfabeto = (ArrayList<Character>) alfabeto.clone();
        String resultado = "";
        for(int i = 0; i < largo; i++) {
            int indice = (int) (Math.random() * copiaAlfabeto.size());
            resultado += copiaAlfabeto.get(indice);
            copiaAlfabeto.remove(indice);
        }
        
        frase.setTexto(resultado);
    }
}
