/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.algoritmos;

import java.util.ArrayList;
import modelo.Algoritmo;

/**
 *
 * @author gerald
 */
public class Vigenere extends Algoritmo{
    
    public Vigenere(int id,String nombreAlgoritmo){
        super(id,nombreAlgoritmo);
    }

    public Vigenere() {
    }
    
    
    
    @Override
    public String Codificar(String mensaje, ArrayList<Character> alfabeto){
        String resultado = "";
        for (int i = 0; i < mensaje.length(); i++) {
            if (i%2 == 0 && mensaje.charAt(i) != ' ') {
                resultado += alfabeto.get((alfabeto.indexOf(mensaje.charAt(i))+2)%alfabeto.size());
            }else if (mensaje.charAt(i) != ' '){
                resultado += alfabeto.get((alfabeto.indexOf(mensaje.charAt(i))+3)%alfabeto.size());
            } else {
                resultado += ' ';
            }
        }
        return resultado;
    }
    
    
    @Override
    public String Decodificar(String mensaje, ArrayList<Character> alfabeto){
        String resultado = "";
        int valorReduccion;
        for (int i = 0; i < mensaje.length(); i++) {
            if (i%2 == 0 && mensaje.charAt(i) != ' ') {
                if ((valorReduccion = alfabeto.indexOf(mensaje.charAt(i))-2)<0) {
                    resultado += alfabeto.get(alfabeto.size()+valorReduccion);
                }else {
                    resultado += alfabeto.get(valorReduccion);
                }
                
            }else if (mensaje.charAt(i) != ' '){
                if ((valorReduccion = alfabeto.indexOf(mensaje.charAt(i))-3)<0) {
                    resultado += alfabeto.get(alfabeto.size()+valorReduccion);
                }else {
                    resultado += alfabeto.get(valorReduccion);
                }
            } else {
                resultado += ' ';
            }
        }
        return resultado;
    }
    
}
