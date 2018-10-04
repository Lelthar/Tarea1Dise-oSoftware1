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
    public String Codificar(ArrayList<Object> mensaje, ArrayList<Character> alfabeto){
        
        String mensajeProcesar = (String) mensaje.get(0);
        int primerCifra = ((int ) mensaje.get(1)) / 10 ;
        int segundaCifra = ((int ) mensaje.get(1)) % 10;
        
        String resultado = "";
        
        for (int i = 0; i < mensajeProcesar.length(); i++) {
            if (i%2 == 0 && mensajeProcesar.charAt(i) != ' ') {
                resultado += alfabeto.get((alfabeto.indexOf(mensajeProcesar.charAt(i))+primerCifra)%alfabeto.size());
            }else if (mensajeProcesar.charAt(i) != ' '){
                resultado += alfabeto.get((alfabeto.indexOf(mensajeProcesar.charAt(i))+segundaCifra)%alfabeto.size());
            } else {
                resultado += ' ';
            }
        }
        return resultado;
    }
    
    
    @Override
    public String Decodificar(ArrayList<Object> mensaje, ArrayList<Character> alfabeto){
        
        String mensajeProcesar = (String) mensaje.get(0);
        int primerCifra = ((int ) mensaje.get(1)) / 10 ;
        int segundaCifra = ((int ) mensaje.get(1)) % 10;
        String resultado = "";
        int valorReduccion;
        
        for (int i = 0; i < mensajeProcesar.length(); i++) {
            if (i%2 == 0 && mensajeProcesar.charAt(i) != ' ') {
                if ((valorReduccion = alfabeto.indexOf(mensajeProcesar.charAt(i))-primerCifra)<0) {
                    resultado += alfabeto.get(alfabeto.size()+valorReduccion);
                }else {
                    resultado += alfabeto.get(valorReduccion);
                }
                
            }else if (mensajeProcesar.charAt(i) != ' '){
                if ((valorReduccion = alfabeto.indexOf(mensajeProcesar.charAt(i))-segundaCifra)<0) {
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
