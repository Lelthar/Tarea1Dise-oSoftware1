/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.frases.frases_builder;

import controlador.frases.FraseBuilder;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author gerald
 */
public class Tipo1FraseBuilder extends FraseBuilder {
    
    public void buildFrase(int largo,ArrayList<Character> alfabeto){
        ArrayList<Character> copiaAlfabeto = (ArrayList<Character>) alfabeto.clone();
        String resultado = "";
        for(int i = 0; i < largo; i++) {
            int indice = (int) (Math.random() * copiaAlfabeto.size());
            int indiceAlfabeto = alfabeto.indexOf(copiaAlfabeto.get(indice));
            int veces = 0;
            
            while(copiaAlfabeto.get(indice).charValue() != alfabeto.get(0).charValue() && (resultado.length() > 0 && alfabeto.get(indiceAlfabeto-1) == resultado.charAt(i-1) ) ) {
                if( veces == 100) {
                    break;
                }
                indice = (int) (Math.random() * copiaAlfabeto.size());
                indiceAlfabeto = alfabeto.indexOf(copiaAlfabeto.get(indice));
                veces++; 
            }
            
            resultado += copiaAlfabeto.get(indice);
            copiaAlfabeto.remove(indice);
        }
        
        frase.setTexto(resultado);
    }
}
