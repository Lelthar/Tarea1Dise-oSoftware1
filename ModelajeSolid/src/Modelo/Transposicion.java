/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author josed
 */
public class Transposicion extends Algoritmo {
    
    
    public Transposicion(int id,String nombreAlgoritmo){
        super(id,nombreAlgoritmo);
       // super();
       
    }

    public Transposicion() {
    }
    
    public ArrayList<String> dividirMensaje(String mensaje ){
        ArrayList<String> listaDividida = new ArrayList<>();
        String valorActual = "";
        int largoMensaje = mensaje.length();
        
        for (int i = 0; i < largoMensaje ; i++) {
            if (mensaje.charAt(i) == ' ' || i+1 == largoMensaje) {
                if (mensaje.charAt(i) == ' ') {
                    listaDividida.add(valorActual);
                    valorActual = "";
                } else {
                    valorActual += mensaje.charAt(i);
                    listaDividida.add(valorActual);
                    valorActual = "";
                }
                
            }else{
                valorActual += mensaje.charAt(i);
            }
        }
            return listaDividida;
        
    }
    
    

    @Override
    public String Codificar(String mensaje, ArrayList<Character> alfabeto){
        String conversion = "";
        StringBuilder resultado = new StringBuilder();
        
        for (int i = mensaje.length(); i > 0 ; i--) {
            conversion += mensaje.charAt(i-1);
        }
        
        ArrayList<String> listaMensaje = dividirMensaje(conversion);
        
        Collections.reverse(listaMensaje);
        
        for (String elemento : listaMensaje) {
            resultado.append(elemento+" ");
        }
        
        return resultado.toString().substring(0,resultado.length()-1);
    }
    
    @Override
    public String Decodificar(String mensaje, ArrayList<Character> alfabeto){
        String conversion = "";
        StringBuilder resultado = new StringBuilder();
        
        for (int i = mensaje.length(); i > 0 ; i--) {
            conversion += mensaje.charAt(i-1);
        }
        
        ArrayList<String> listaMensaje = dividirMensaje(conversion);
        
        Collections.reverse(listaMensaje);
        
        for (String elemento : listaMensaje) {
            resultado.append(elemento+" ");
        }
        
        return resultado.toString().substring(0,resultado.length()-1);
    }
     
}
