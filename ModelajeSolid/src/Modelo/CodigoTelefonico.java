/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author josed
 */
public class CodigoTelefonico extends Algoritmo {
    
    private ArrayList distSimbolos ;

    public CodigoTelefonico(int id,String nombreAlgoritmo){
        super(id,nombreAlgoritmo);
    }

    public CodigoTelefonico() {
    }
    
    @Override
    public String Codificar(String mensaje, ArrayList<Character> alfabeto){
        
        
        return "Debe ser programado por Gerald Codificar codigoTelefonico";
    }
    @Override
    public String Decodificar(String mensaje, ArrayList<Character> alfabeto){
        return "Debe ser programado por Gerald Decodificar codigoTelefonico";
    }
    
   
    
    
    
    
    
}
