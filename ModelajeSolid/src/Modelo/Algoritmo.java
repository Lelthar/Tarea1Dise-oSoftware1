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
public class Algoritmo {
    
    private int id;
    private String nombreAlgoritmo;
    
    public Algoritmo(int id,String nombre){
        this.id = id;
        this.nombreAlgoritmo = nombre;
    }

    public Algoritmo() {
    }
    
    
    public String getNombreAlgoritmo() {
        return nombreAlgoritmo;
    }
    
    public void setNombreAlgoritmo(String nombreAlgoritmo) {
        this.nombreAlgoritmo = nombreAlgoritmo;
    }
    
    public String Decodificar(String mensaje, ArrayList<Character> alfabeto){
     
        return "A";
    }
    
    public String Codificar(String mensaje, ArrayList<Character> alfabeto){
        
        return "B";
    }
    
    
}
